package com.fn.qms.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.utils.AppLog;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.ApplicationContext;

public class Scan100Process extends Thread {
    public Scan100Process(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.producer = applicationContext.getBean(KafkaProducer.class);
    }

    private ApplicationContext context;
    KafkaProducer<String, String> producer;
    @Override
    public void run() {
        AppLog.info("SCAN100 PROCESS!!!");
        ObjectMapper objectMapper = new ObjectMapper();
        while (true) {
            Object obj;
            try {
                obj = Queue.notiQueue.poll();
                // AppLog.info(obj);
                if (obj != null) {
                    AppLog.info("Send message to Kafka : "  );
                    NotiDto dto =(NotiDto) obj;
                    ProducerRecord<String, String>
                            message = new ProducerRecord<>(dto.getTopic(), dto.getContent());
                    AppLog.info("Send message to Kafka : "  +  producer.send(message));

                }
                Thread.sleep(100);
            } catch (Exception e) {
                AppLog.error(e);
            }
        }
    }
}
