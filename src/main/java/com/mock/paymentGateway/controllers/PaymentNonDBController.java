package com.mock.paymentGateway.controllers;

import com.mock.paymentGateway.models.Payment;
import com.mock.paymentGateway.repositories.PaymentRepository;
import com.mock.paymentGateway.services.MockFINetwork;
import com.mock.paymentGateway.services.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author arsharma
 */
@RestController
@RequestMapping("/payment/v2")
public class PaymentNonDBController {

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
            return payment;
        }

        //throw invalidated payment payload
        payment.setPaymentStatus("Invalid Payment");
        return payment;
    }

}
