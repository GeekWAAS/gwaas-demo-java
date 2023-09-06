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
    private Integer paymentCurrencyDigits;
    private String tokenContractAddress;
    private BigDecimal exchangeRate;
    private BigInteger cryptoOrderAmountWei;
    private BigInteger cryptoPaidAmountWei;
    private Instant createTime;
    private Instant expireTime;
    private Instant confirmTime;
    private String paymentTransactionHash;
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

    public String getTokenContractAddress() {
        return tokenContractAddress;
    }

    public AcquireOrderInfo setTokenContractAddress(String tokenContractAddress) {
        this.tokenContractAddress = tokenContractAddress;
        return this;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public AcquireOrderInfo setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    public BigInteger getCryptoOrderAmountWei() {
        return cryptoOrderAmountWei;
    }

    public AcquireOrderInfo setCryptoOrderAmountWei(BigInteger cryptoOrderAmountWei) {
        this.cryptoOrderAmountWei = cryptoOrderAmountWei;
        return this;
    }

    public BigInteger getCryptoPaidAmountWei() {
        return cryptoPaidAmountWei;
    }

    public AcquireOrderInfo setCryptoPaidAmountWei(BigInteger cryptoPaidAmountWei) {
        this.cryptoPaidAmountWei = cryptoPaidAmountWei;
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

    public Instant getConfirmTime() {
        return confirmTime;
    }

    public AcquireOrderInfo setConfirmTime(Instant confirmTime) {
        this.confirmTime = confirmTime;
        return this;
    }

    public String getPaymentTransactionHash() {
        return paymentTransactionHash;
    }

    public AcquireOrderInfo setPaymentTransactionHash(String paymentTransactionHash) {
        this.paymentTransactionHash = paymentTransactionHash;
        return this;
    }

    public String getCashierUrl() {
        return cashierUrl;
    }

    public AcquireOrderInfo setCashierUrl(String cashierUrl) {
        this.cashierUrl = cashierUrl;
        return this;
    }

    public Integer getPaymentCurrencyDigits() {
        return paymentCurrencyDigits;
    }

    public AcquireOrderInfo setPaymentCurrencyDigits(Integer paymentCurrencyDigits) {
        this.paymentCurrencyDigits = paymentCurrencyDigits;
        return this;
    }
}
