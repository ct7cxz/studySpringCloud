package com.ct.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

    @Bean
    public Logger.Level toLog() {
        return Logger.Level.FULL;
    }
}
