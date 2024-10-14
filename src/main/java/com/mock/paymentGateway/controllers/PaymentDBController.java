package com.mock.paymentGateway.controllers;

import com.mock.paymentGateway.models.Payment;
import com.mock.paymentGateway.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/payment/v1")
public class PaymentDBController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment createDBResponse(@RequestBody Payment payment) {
        payment.setPaymentDate(new Date());
        return paymentRepository.saveAndFlush(payment);
    }
}
