package com.ct.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
@Slf4j
public class PaymentService {

    public String getMessageOK(String id) {
        return "线程池" + Thread.currentThread().getName() + "返回成功:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_fallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String getMessageTimeout(String id) throws InterruptedException {
        Thread.sleep(3000);
        return "线程池" + Thread.currentThread().getName() + "返回成功:" + id;
    }

    public String paymentInfo_fallbackMethod(String id) {
        log.info("timeoutHandler方法调用");
        return "线程池" + Thread.currentThread().getName() + "timeoutHandler:" + id;
    }

    @HystrixCommand(fallbackMethod = "circuitBreakerFallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//最大错误请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//正确率，低于这个正确率时，服务会触发熔断
            })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("输入的数字必须大于0");
        }
        return "当前线程号" + Thread.currentThread().getName() + UUID.randomUUID().toString();
    }

    public String circuitBreakerFallbackMethod(Integer id) {
        return "请输入大于0的数字" + id;
    }

}
