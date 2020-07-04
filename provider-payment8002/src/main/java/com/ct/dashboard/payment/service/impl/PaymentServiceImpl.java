package com.ct.dashboard.payment.service.impl;

import com.ct.dashboard.common.entities.Payment;
import com.ct.dashboard.payment.dao.PaymentDao;
import com.ct.dashboard.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    /**
     * 新建支付信息
     * @param payment
     * @return
     */
    @Override
    public Payment createPayment(Payment payment) {
        int id = paymentDao.createPayment(payment);
        log.info("插入的id为:"+payment.getId());
        return payment;
    }

    /**
     * 根据id查询支付信息
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
