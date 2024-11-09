package com.mock.paymentGateway.controllers;

import com.mock.paymentGateway.models.Payment;
import com.mock.paymentGateway.repositories.PaymentRepository;
import com.mock.paymentGateway.services.MockFINetwork;
import com.mock.paymentGateway.services.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/payment/v1")
public class PaymentDBController {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private MockFINetwork mockFINetwork;

    @PostMapping
    public Payment createDBResponse(@RequestBody Payment payment) {

        payment.setPaymentDate(new Date());

        //validate payments before proceeding for multiple standards
        if(PaymentValidator.validatePayment(payment)) {
            payment.setPaymentStatus(mockFINetwork.processPaymentMethod(payment.getPaymentMethod()).toString());
            return paymentRepository.saveAndFlush(payment);
        }

        payment.setPaymentStatus("Invalid Payment");
        return payment;
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
    }
}
