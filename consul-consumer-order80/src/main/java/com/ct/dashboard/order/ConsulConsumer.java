package com.ct.dashboard.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumer.class);
    }

}
