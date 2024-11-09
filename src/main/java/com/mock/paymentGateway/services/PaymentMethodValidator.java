package com.mock.paymentGateway.services;

import com.mock.paymentGateway.models.Payment;
import com.mock.paymentGateway.models.PaymentHelper;
import com.mock.paymentGateway.models.PaymentMethod;


public class PaymentMethodValidator {

    public static boolean validatePaymentMethod(Payment payment) {

        PaymentMethod paymentMethod = payment.getPaymentMethod();
        boolean valid = true;

        valid &= validateMethodType(payment);

        if(valid && PaymentHelper.isCardPayment(paymentMethod.getMethodType())) {
            valid = validateCCExpiry(payment) && validateCardNumber(payment);;
        }

        return valid;
    }


    public static boolean validateMethodType(Payment payment) {
        try {
            PaymentHelper.PaymentMethodTypeEnum paymentMethodType = PaymentHelper.PaymentMethodTypeEnum.valueOf(payment.getPaymentMethod().getMethodType());

            // Validate if it's a supported payment method
            if (paymentMethodType == PaymentHelper.PaymentMethodTypeEnum.CC ||
                    paymentMethodType == PaymentHelper.PaymentMethodTypeEnum.DC ||
                    paymentMethodType == PaymentHelper.PaymentMethodTypeEnum.ECHECK) {
                return true;
            }

        } catch (IllegalArgumentException e) {
            // Handle invalid PaymentMethodTypeEnum gracefully
            // Log the error or handle it as needed
            payment.seterrorCode("103");
            payment.seterrorMsg("Invalid Payment Method Name: " + payment.getPaymentMethod().getMethodType());
        }

        return false; // Return false if invalid or error occurs
    }


    public static boolean validateCCExpiry(Payment payment) {
        if(payment.getPaymentMethod().getCcExpiry().isNotExpired()) {
            return true;
        }

        //error code and key for invalid payment
        payment.seterrorCode("104");
        payment.seterrorMsg("Card is Expired");
        return false;
    }

    public static boolean validateCardNumber(Payment payment) {
        if(payment.getPaymentMethod().getAccountNumber().length() == 16) {
            return true;
        }

        //error code and key for invalid payment
        payment.seterrorCode("105");
        payment.seterrorMsg("Invalid Card Number");
        return false;
    }
}
