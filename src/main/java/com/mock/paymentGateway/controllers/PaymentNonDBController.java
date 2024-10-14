package com.mock.paymentGateway.controllers;

import com.mock.paymentGateway.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/v2")
public class PaymentNonDBController {

    private Payment payment;

}
