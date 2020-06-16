package com.ct.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String getMessageOK(String id) {
        return "线程池" + Thread.currentThread().getName() + "返回成功:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_fallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String getMessageTimeout(String id) throws InterruptedException {
        Thread.sleep(3000);
        return "线程池" + Thread.currentThread().getName() + "返回成功:" + id;
    }

    public String paymentInfo_fallbackMethod(String id) {
        return "线程池" + Thread.currentThread().getName() + "timeoutHandler:" + id;
    }

}
