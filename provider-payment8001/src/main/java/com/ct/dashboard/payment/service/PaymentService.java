package com.ct.dashboard.payment.service;

import com.ct.common.entities.*;
import com.ct.dashboard.common.entities.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
