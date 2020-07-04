package com.ct.consumerOrder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "provider-hystrix-payment", fallback = PaymentFeignFallback.class)
public interface PaymentFeignServer {

    @GetMapping(path = "payment/hystrix/ok/{id}")
    String getMessageOK(@PathVariable("id") String id);

    @GetMapping(path = "payment/hystrix/timeout/{id}")
    String getMessageTimeout(@PathVariable("id") String id);

}
