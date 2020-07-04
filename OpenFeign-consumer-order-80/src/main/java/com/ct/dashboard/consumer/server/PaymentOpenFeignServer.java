package com.ct.dashboard.consumer.server;

import com.ct.dashboard.common.entities.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PROVIDER-PAYMENT")
@Component
public interface PaymentOpenFeignServer {

    @GetMapping("/payment/getPayment/{id}")
    CommentResult getPayment(@PathVariable("id") Long id);

    @GetMapping(path = "/payment/feign/timeout")
    String timeOut() throws InterruptedException;

}
