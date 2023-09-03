package com.geekwaas.core.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public class AcquireNewOrderInfo {
    private String orderId;
    private String referenceOrderNo;
    private String requestCurrency;
    private BigDecimal requestAmount;
    private AcquireOrderStatus status;
    private Instant createTime;
    private Instant expireTime;
    private String cashierUrl;

    public String getOrderId() {
        return orderId;
    }

    public AcquireNewOrderInfo setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getReferenceOrderNo() {
        return referenceOrderNo;
    }

    public AcquireNewOrderInfo setReferenceOrderNo(String referenceOrderNo) {
        this.referenceOrderNo = referenceOrderNo;
        return this;
    }

    public String getRequestCurrency() {
        return requestCurrency;
    }

    public AcquireNewOrderInfo setRequestCurrency(String requestCurrency) {
        this.requestCurrency = requestCurrency;
        return this;
    }

    public BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public AcquireNewOrderInfo setRequestAmount(BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
        return this;
    }

    public AcquireOrderStatus getStatus() {
        return status;
    }

    public AcquireNewOrderInfo setStatus(AcquireOrderStatus status) {
        this.status = status;
        return this;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public AcquireNewOrderInfo setCreateTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public Instant getExpireTime() {
        return expireTime;
    }

    public AcquireNewOrderInfo setExpireTime(Instant expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public String getCashierUrl() {
        return cashierUrl;
    }

    public AcquireNewOrderInfo setCashierUrl(String cashierUrl) {
        this.cashierUrl = cashierUrl;
        return this;
    }
}
