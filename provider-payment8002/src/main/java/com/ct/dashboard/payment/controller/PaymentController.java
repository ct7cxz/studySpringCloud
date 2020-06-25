package com.ct.dashboard.payment.controller;

import com.ct.dashboard.common.entities.CommentResult;
import com.ct.dashboard.common.entities.Payment;
import com.ct.dashboard.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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
            return new CommentResult(200, "查询成功！" + serverPort, payment);
        }
        return new CommentResult(500, "未能找到ID为" + id);
    }

}
