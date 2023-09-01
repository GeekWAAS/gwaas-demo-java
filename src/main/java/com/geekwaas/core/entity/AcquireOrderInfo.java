package com.geekwaas.core.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public class AcquireOrderInfo {
    private String orderId;
    private String referenceOrderNo;
    private String requestCurrency;
    private BigDecimal requestAmount;
    private AcquireOrderStatus status;
    private GWaasChainType paymentChainType;
    private Long chainId;
    private GWaasCurrencyType paymentCurrencyType;
    private String paymentCurrency;
    private String contractAddress;
    private BigDecimal exchangeRate;
    private BigInteger paymentAmount;
    private BigInteger actualPaymentAmount;
    private Instant createTime;
    private Instant expireTime;
    private Instant completeTime;
    private String transactionHash;
    private String cashierUrl;

    public String getOrderId() {
        return orderId;
    }

    public AcquireOrderInfo setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getReferenceOrderNo() {
        return referenceOrderNo;
    }

    public AcquireOrderInfo setReferenceOrderNo(String referenceOrderNo) {
        this.referenceOrderNo = referenceOrderNo;
        return this;
    }

    public String getRequestCurrency() {
        return requestCurrency;
    }

    public AcquireOrderInfo setRequestCurrency(String requestCurrency) {
        this.requestCurrency = requestCurrency;
        return this;
    }

    public BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public AcquireOrderInfo setRequestAmount(BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
        return this;
    }

    public AcquireOrderStatus getStatus() {
        return status;
    }

    public AcquireOrderInfo setStatus(AcquireOrderStatus status) {
        this.status = status;
        return this;
    }

    public GWaasChainType getPaymentChainType() {
        return paymentChainType;
    }

    public AcquireOrderInfo setPaymentChainType(GWaasChainType paymentChainType) {
        this.paymentChainType = paymentChainType;
        return this;
    }

    public Long getChainId() {
        return chainId;
    }

    public AcquireOrderInfo setChainId(Long chainId) {
        this.chainId = chainId;
        return this;
    }

    public GWaasCurrencyType getPaymentCurrencyType() {
        return paymentCurrencyType;
    }

    public AcquireOrderInfo setPaymentCurrencyType(GWaasCurrencyType paymentCurrencyType) {
        this.paymentCurrencyType = paymentCurrencyType;
        return this;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public AcquireOrderInfo setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
        return this;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public AcquireOrderInfo setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
        return this;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public AcquireOrderInfo setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    public BigInteger getPaymentAmount() {
        return paymentAmount;
    }

    public AcquireOrderInfo setPaymentAmount(BigInteger paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public BigInteger getActualPaymentAmount() {
        return actualPaymentAmount;
    }

    public AcquireOrderInfo setActualPaymentAmount(BigInteger actualPaymentAmount) {
        this.actualPaymentAmount = actualPaymentAmount;
        return this;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public AcquireOrderInfo setCreateTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public Instant getExpireTime() {
        return expireTime;
    }

    public AcquireOrderInfo setExpireTime(Instant expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public Instant getCompleteTime() {
        return completeTime;
    }

    public AcquireOrderInfo setCompleteTime(Instant completeTime) {
        this.completeTime = completeTime;
        return this;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public AcquireOrderInfo setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
        return this;
    }

    public String getCashierUrl() {
        return cashierUrl;
    }

    public AcquireOrderInfo setCashierUrl(String cashierUrl) {
        this.cashierUrl = cashierUrl;
        return this;
    }
}
