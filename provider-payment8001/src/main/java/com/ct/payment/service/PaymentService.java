package com.ct.payment.service;

import com.ct.common.entities.*;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
