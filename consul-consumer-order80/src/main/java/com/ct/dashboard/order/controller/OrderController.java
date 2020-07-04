package com.ct.dashboard.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String URI = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/consul")
    public String createPayment() {
        return restTemplate.getForObject(URI + "/consul",String.class);
    }

}
