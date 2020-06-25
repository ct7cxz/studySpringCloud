package com.ct.dashboard.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(path = "/zk")
    public String zookeeperTest() {
        return "spring cloud zookeeper--port:" + port + "\t" + UUID.randomUUID().toString();
    }
}
