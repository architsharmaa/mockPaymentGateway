package com.mock.paymentGateway.services;

import com.mock.paymentGateway.models.Payment;

/**
 * This is main validating class responsible for validating payment payload
 * @author arsharma
 */
public class PaymentValidator {

    /**
     * Validate a payment method main calling function
     * @param payment
     * @return
     */
    public static boolean validatePayment(Payment payment) {
        return validatePaymentAmount(payment) &&
                validateProcessingFee(payment) &&
                PaymentMethodValidator.validatePaymentMethod(payment);
    }

    /**
     * Validate payment amount should be non negative or zero
     * @param payment
     * @return boolean, if error it populates the error key an error code
     */
    public static boolean validatePaymentAmount(Payment payment) {
        if(payment.getPaymentAmount() > 0) {
            return true;
        }
        //error code and key for invalid payment
        payment.seterrorCode("101");
        payment.seterrorMsg("Invalid Payment Amount");
        return false;
    }

    /**
     * Validate processing amount should be non-negative
     * @param payment
     * @return boolean, if error it populates the error key an error code
     */
    public static boolean validateProcessingFee(Payment payment) {
        if(payment.getProcessingFee() > 0) {
            return true;
        }
        //error code and key for invalid payment
        payment.seterrorCode("102");
        payment.seterrorMsg("Invalid Processing Amount");
        return false;
    }


}
