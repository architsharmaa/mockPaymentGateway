package com.mock.paymentGateway.models;

public class PaymentMethod {

    private String id;
    private String accountNumber;
    private String methodType;
    private String cardHolderName;
    private String description;
    private String routingNumber;
    private String fiName;
    private String activeFlag;
    private CardPaymentMethodExpiry ccExpiry;

    // Default Constructor
    public PaymentMethod() {
    }

    // Parameterized Constructor
    public PaymentMethod(String id, String accountNumber, String methodType, String cardHolderName,
                         String description, String routingNumber, String fiName,
                         String activeFlag, CardPaymentMethodExpiry ccExpiry) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.methodType = methodType;
        this.cardHolderName = cardHolderName;
        this.description = description;
        this.routingNumber = routingNumber;
        this.fiName = fiName;
        this.activeFlag = activeFlag;
        this.ccExpiry = ccExpiry;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public CardPaymentMethodExpiry getCcExpiry() {
        return ccExpiry;
    }

    public void setCcExpiry(CardPaymentMethodExpiry ccExpiry) {
        this.ccExpiry = ccExpiry;
    }
}
