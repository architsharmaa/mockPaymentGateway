package com.mock.paymentGateway.models;

/**
 * @author arsharma
 */
public class PaymentHelper {

    // Enum declared for payment status
    public static enum PaymentStatus {
        SUCCESS,
        FAILURE,
        PENDING,
        DECLINED
    }

    //Enum declared for payment method type
    public static enum PaymentMethodTypeEnum {
        CC, //Credit Card
        DC, //Debit Card
        ECHECK //E check
    }

    /**
     * Checks if the payment method is a card payment or not
     * @param methodType
     * @return boolean
     */
    public static boolean isCardPayment(String methodType) {

        PaymentMethodTypeEnum paymentMethodType = PaymentMethodTypeEnum.valueOf(methodType);

        //Enum comparisons for cards (Credit Card and Debit Card)
        return paymentMethodType == PaymentMethodTypeEnum.CC ||
                paymentMethodType == PaymentMethodTypeEnum.DC;
    }


}
