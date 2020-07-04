package com.ct.dashboard.consumerOrder.controller;

import com.ct.dashboard.consumerOrder.service.PaymentFeignServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "global")
public class ConsumerController {

    @Autowired
    private PaymentFeignServer server;

    @GetMapping(path = "consumer/getMessageOK/{id}")
    public String getFeignMessageOk(@PathVariable("id") String id) {
        return server.getMessageOK(id);
    }

    @GetMapping(path = "consumer/getMessageTimeout/{id}")
    /*@HystrixCommand(fallbackMethod = "consumerHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})*/
    @HystrixCommand
    public String getFeignMessageTimeout(@PathVariable("id") String id) {
        int i = 1 / 0;
        return server.getMessageTimeout(id);
    }

    public String consumerHandler(String id) {
        return "调用的客户端，超时连接回调方法" + id;
    }

    public String global() {
        return "调用了配置的全局，回调方法";
    }
}
