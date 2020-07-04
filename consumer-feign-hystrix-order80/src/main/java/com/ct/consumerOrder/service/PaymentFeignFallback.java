package com.ct.consumerOrder.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallback implements PaymentFeignServer{
    @Override
    public String getMessageOK(String id) {
        return "null";
    }

    @Override
    public String getMessageTimeout(String id) {
        return null;
    }

}
