package com.ct.cloudStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamCloud8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamCloud8801.class, args);
    }
}
