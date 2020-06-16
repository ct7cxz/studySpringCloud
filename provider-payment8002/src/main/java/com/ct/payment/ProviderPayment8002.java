package com.ct.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderPayment8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8002.class,args);
    }

}
