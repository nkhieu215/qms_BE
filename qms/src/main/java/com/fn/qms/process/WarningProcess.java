package com.fn.qms.process;//package com.difitech.process;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.utils.AppLog;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;



public class WarningProcess extends Thread {

    public WarningProcess(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.producer = applicationContext.getBean(KafkaProducer.class);
    }

    private ApplicationContext context;
    KafkaProducer<String, String> producer;
    @Override
    public void run() {
        AppLog.info("WARNING PROCESS!!!");
        ObjectMapper objectMapper = new ObjectMapper();
        while (true) {
            Object obj;
            try {
                obj = Queue.notiQueue.poll();
                // AppLog.info(obj);
                if (obj != null) {
                    NotiDto dto =(NotiDto) obj;
                    ProducerRecord<String, String> message = new ProducerRecord<>(dto.getTopic(), dto.getContent());
                    AppLog.info("SendKafka : "  +  producer.send(message));

                }
                Thread.sleep(100);
            } catch (Exception e) {
                AppLog.error(e);
            }
        }
    }
}
