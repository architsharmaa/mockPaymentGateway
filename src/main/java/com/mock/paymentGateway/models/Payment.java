package com.mock.paymentGateway.models;

import jakarta.persistence.*;
import java.util.Date;

/**
 * @author arsharma
 */
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long paymentId;

    @Column(name = "referenceId", nullable = false)
    private Long referenceId;

    @Column(name = "paymentAmount", nullable = false)
    private Double paymentAmount;

    @Column(name = "processingFee", nullable = false)
    private Double processingFee;

    @Column(name = "merchantRefNum", length = 255)
    private String merchantRefNum;

    @Column(name = "paymentTypeDescription", length = 255)
    private String paymentTypeDescription;

    @Column(name = "paymentStatus", length = 50)
    private String paymentStatus;

    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    // Transient field for PaymentMethod
    @Transient
    private PaymentMethod paymentMethod;

    /**
     * This attributes can be used to return error conditions
     */
    @Transient
    private String errorCode;
    @Transient
    private String errorMsg;

    // Constructors
    public Payment() {}

    public Payment(Long referenceId, Double paymentAmount, Double processingFee, String merchantRefNum,
                   String paymentTypeDescription, String paymentStatus, Date paymentDate,
                   PaymentMethod paymentMethod) {
        this.referenceId = referenceId;
        this.paymentAmount = paymentAmount;
        this.processingFee = processingFee;
        this.merchantRefNum = merchantRefNum;
        this.paymentTypeDescription = paymentTypeDescription;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String geterrorCode() {
        return errorCode;
    }

    public String geterrorMsg() {
        return errorMsg;
    }

    public void seterrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void seterrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
