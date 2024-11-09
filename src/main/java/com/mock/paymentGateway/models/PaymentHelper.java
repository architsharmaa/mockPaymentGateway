package com.mock.paymentGateway.models;

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
     *
     * @param methodType
     * @return boolean
     */
    public static boolean isCardPayment(String methodType) {

        PaymentMethodTypeEnum paymentMethodType = PaymentMethodTypeEnum.valueOf(methodType);

        return paymentMethodType == PaymentMethodTypeEnum.CC ||
                paymentMethodType == PaymentMethodTypeEnum.DC;
    }


}
