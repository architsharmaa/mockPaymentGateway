package com.mock.paymentGateway.controllers;

import com.mock.paymentGateway.models.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author arsharma
 */
@RestController
@RequestMapping("/payment/v2")
public class PaymentNonDBController {

    private Payment payment;

}
