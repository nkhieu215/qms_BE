package com.fn.sap.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "sap.service.host", havingValue = "")
@EnableFeignClients(basePackages = "com.fn.sap.service")
public class SapServiceConfig {
}
