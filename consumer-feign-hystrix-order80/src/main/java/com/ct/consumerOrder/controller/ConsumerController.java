package com.ct.consumerOrder.controller;

import com.ct.consumerOrder.service.PaymentFeignServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private PaymentFeignServer server;

    @GetMapping(path = "consumer/getMessageOK/{id}")
    public String getFeignMessageOk(@PathVariable("id") String id) {
        return server.getMessageOK(id);
    }

    @GetMapping(path = "consumer/getMessageTimeout/{id}")
    @HystrixCommand(fallbackMethod = "")
    public String getFeignMessageTimeout(@PathVariable("id") String id) {
        return server.getMessageTimeout(id);
    }


}
