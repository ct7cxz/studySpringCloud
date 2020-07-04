package com.ct.payment.controller;

import com.ct.common.entities.*;
import com.ct.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/payment",produces = "application/json;charset=utf-8")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 创建支付信息
     *
     * @param payment
     * @return
     */
    @PostMapping("/createPayment")
    public CommentResult createPayment(@RequestBody Payment payment) {
        Payment createPayment = paymentService.createPayment(payment);
        if (createPayment.getId() != null) {
            return new CommentResult(200, "success:" + serverPort, createPayment);
        }
        return new CommentResult(500, "新增失败");
    }

    /**
     * 依据id查询支付信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getPayment/{id}")
    public CommentResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommentResult(200, "查询成功！:" + serverPort, payment);
        }
        return new CommentResult(500, "未能找到ID为" + id);
    }

    @GetMapping(path = "/discoverClient")
    public Object discoverClient() {
        List<String> serverList = discoveryClient.getServices();

        for (String s : serverList) {
            log.info(s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getUri()+"\t"+instance.getHost()+"\t"+instance.getPort());
        }
        return discoveryClient;
    }

    //open feign 超时等待修改
    @GetMapping(path = "/feign/timeout")
    public String timeOut() throws InterruptedException {
        Thread.sleep(3000);
        return serverPort;
    }

}
