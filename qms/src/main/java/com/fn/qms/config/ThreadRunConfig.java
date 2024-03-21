package com.fn.qms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThreadRunConfig {
    @Value("${thread.push.warning}")
    public  Integer warning;
}
