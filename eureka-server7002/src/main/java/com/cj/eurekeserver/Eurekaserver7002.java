package com.cj.eurekeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver7002.class);
    }
}
