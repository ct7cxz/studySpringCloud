package com.ct.consumers.controller;

import com.ct.common.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String URI = "http://PROVIDER-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/consumer/createPayment")
    public CommentResult createPayment(Payment payment) {
        return restTemplate.postForObject(URI + "/payment/createPayment", payment, CommentResult.class);
    }

    @GetMapping(path = "/consumer/getpaymen/{id}")
    public CommentResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URI + "/payment/getPayment/" + id, CommentResult.class);
    }

    // 使用Ribbon请求调用接口
    @GetMapping(path = "/consumer/Ribbon/getPayment/{id}")
    public CommentResult getRibbonPayment(@PathVariable("id") Long id) {
        ResponseEntity<CommentResult> entity = restTemplate.getForEntity(URI + "/payment/getPayment/" + id, CommentResult.class);
        HttpStatus statusCode = entity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommentResult(500, "请求失败!");
        }
    }

    @GetMapping(path = "/consumer/ribbon/createPayment")
    public CommentResult createRibbonPayment(Payment payment) {
        ResponseEntity<CommentResult> entity = restTemplate.postForEntity(URI + "/payment/createPayment", payment, CommentResult.class);
        HttpStatus statusCode = entity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommentResult(500, "失败");
        }
    }

}
