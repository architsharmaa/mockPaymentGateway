package com.mock.paymentGateway.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long paymentId;

    @Column(name = "refernceId", nullable = false)
    private Long refernceId;

    @Column(name = "paymentAmount", nullable = false)
    private Double paymentAmount;

    @Column(name = "processingFee", nullable = false)
    private Double processingFee;

    @Column(name = "merchantRefNum", length = 255)
    private String merchantRefNum;

    @Column(name = "paymentTypeCode", length = 50)
    private String paymentTypeCode;

    @Column(name = "paymentTypeDescription", length = 255)
    private String paymentTypeDescription;

    @Column(name = "paymentStatus", length = 50)
    private String paymentStatus;

    @Column(name = "paymenDate")
    @Temporal(TemporalType.DATE)
    private Date paymenDate;

    // Constructors
    public Payment() {}

    public Payment(Long refernceId, Double paymentAmount, Double processingFee, String merchantRefNum,
                   String paymentTypeCode, String paymentTypeDescription, String paymentStatus, Date paymenDate) {
        this.refernceId = refernceId;
        this.paymentAmount = paymentAmount;
        this.processingFee = processingFee;
        this.merchantRefNum = merchantRefNum;
        this.paymentTypeCode = paymentTypeCode;
        this.paymentTypeDescription = paymentTypeDescription;
        this.paymentStatus = paymentStatus;
        this.paymenDate = paymenDate;
    }

    // Getters and Setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getRefernceId() {
        return refernceId;
    }

    public void setRefernceId(Long refernceId) {
        this.refernceId = refernceId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    public String getMerchantRefNum() {
        return merchantRefNum;
    }

    public void setMerchantRefNum(String merchantRefNum) {
        this.merchantRefNum = merchantRefNum;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getPaymentTypeDescription() {
        return paymentTypeDescription;
    }

    public void setPaymentTypeDescription(String paymentTypeDescription) {
        this.paymentTypeDescription = paymentTypeDescription;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymenDate() {
        return paymenDate;
    }

    public void setPaymenDate(Date paymenDate) {
        this.paymenDate = paymenDate;
    }

}
