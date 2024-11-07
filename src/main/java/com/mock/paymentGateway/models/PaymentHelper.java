package com.mock.paymentGateway.models;

public class AssetEnums {

    // Enum declared for payment status
    public static enum PaymentStatus {
        SUCCESS,
        FAILURE,
        PENDING,
        DECLINED
    }

    //Enum declared for payment method type
    public static enum PaymentMethodType {
        CC, //Credit Card
        DC, //Debit Card
        ECHECK //E check
    }


}
