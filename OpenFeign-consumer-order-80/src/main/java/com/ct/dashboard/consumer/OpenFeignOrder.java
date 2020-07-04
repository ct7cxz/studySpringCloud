package com.ct.dashboard.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class OpenFeignOrder {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrder.class);
    }

}
