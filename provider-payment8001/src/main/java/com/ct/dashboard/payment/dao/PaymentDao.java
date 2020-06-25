package com.ct.dashboard.payment.dao;

import com.ct.common.entities.*;
import com.ct.dashboard.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int createPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
