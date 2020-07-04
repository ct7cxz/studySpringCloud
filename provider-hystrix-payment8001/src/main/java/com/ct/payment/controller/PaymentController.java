package com.ct.payment.controller;

import com.ct.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping(path = "/payment/hystrix/ok/{id}")
    public String getMessageOK(@PathVariable("id") String id) {
        log.info("消息返回成功");
        return service.getMessageOK(id);
    }

    @GetMapping(path = "/payment/hystrix/timeout/{id}")
    public String getMessageTimeout(@PathVariable("id") String id) throws InterruptedException {
        log.info("消息返回超时");
        return service.getMessageTimeout(id);
    }

    @GetMapping(path = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = service.paymentCircuitBreaker(id);
        log.info(result);
        return result;
    }

}
