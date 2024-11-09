package com.mock.paymentGateway.services;

import com.mock.paymentGateway.models.PaymentHelper;
import com.mock.paymentGateway.models.PaymentMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockFINetwork {

    //we are keeping sample card numbers for declined and accepted status
    //other than the above will be payment failed
    @Value("${valid.cardNumber.list:4111111111111111,5454545454545454}")
    private List<String> validCardNumbersList;
    @Value("${invalid.cardNumber.list:4917484589897107}")
    private List<String> declinedCardNumberList;

    /**
     * 
     * @param paymentMethod
     * @return
     */
    public Enum<PaymentHelper.PaymentStatus> processPaymentMethod(PaymentMethod paymentMethod) {

        if(PaymentHelper.PaymentMethodTypeEnum.ECHECK == PaymentHelper.PaymentMethodTypeEnum.valueOf(paymentMethod.getMethodType())) {
            //To Do : do something about Echecks payment method simulation in terms for
            //accepted routing numbers and declined routing numbers something on those line
            return PaymentHelper.PaymentStatus.SUCCESS;
        } else {
            String cardNumber = paymentMethod.getAccountNumber();

            //simulating a success and decline status
            if(validCardNumbersList.contains(cardNumber)) {
                //To Do create a separate MC and Visa distinguishes
                return PaymentHelper.PaymentStatus.SUCCESS;
            } else if(declinedCardNumberList.contains(cardNumber)) {
                return PaymentHelper.PaymentStatus.DECLINED;
            }

        }

        return PaymentHelper.PaymentStatus.FAILURE;
    }

}
