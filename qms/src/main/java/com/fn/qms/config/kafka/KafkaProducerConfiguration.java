package com.fn.qms.config.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.kafka.bootstrap-servers", havingValue = "")
public class KafkaProducerConfiguration {
    @Bean
    public KafkaProducer<String, String> kafkaProducer(KafkaProperties kafkaProperties) {
        return new KafkaProducer<>(kafkaProperties.getProducerProps());
    }
}
