package com.ct.dashboard.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String URI = "http://provider-payment";

    @Autowired
    private RestTemplate restTemlptle;

    @RequestMapping("/zk")
    public String consumerZkTest() {
        return restTemlptle.getForObject(URI+"/zk",String.class);
    }

}
