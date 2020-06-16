package com.ct.consumer.controller;

import com.ct.common.entities.CommentResult;
import com.ct.consumer.server.PaymentOpenFeignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignOrderController {

    @Autowired
    private PaymentOpenFeignServer server;

    @GetMapping("/consumer/getPayment/{id}")
    CommentResult getPayment(@PathVariable("id") Long id) {
        return server.getPayment(id);
    }

    @GetMapping(path = "/consumer/feign/timeout")
    public String timeOut() throws InterruptedException {
        server.timeOut();
        return null;
    }
}
