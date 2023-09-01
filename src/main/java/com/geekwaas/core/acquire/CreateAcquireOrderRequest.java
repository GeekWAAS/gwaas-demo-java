package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasRequest;
import com.geekwaas.core.entity.GWaasAcquireMethod;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Instant;

public class CreateAcquireOrderRequest implements GWaasRequest<CreateAcquireOrderResponse> {
    private final String referenceOrderNo;
    private final String title;
    private String orderDesc;
    private final String currency;
    private final BigDecimal amount;
    private final GWaasAcquireMethod acquireMethod;
    private String notifyUrl;
    private String successCallbackUrl;
    private String cancelCallbackUrl;
    private Instant expireTime;

    public CreateAcquireOrderRequest(String referenceOrderNo, String title, String currency, BigDecimal amount, GWaasAcquireMethod acquireMethod) {
        this.referenceOrderNo = referenceOrderNo;
        this.title = title;
        this.currency = currency;
        this.amount = amount;
        this.acquireMethod = acquireMethod;
    }


    @Override
    public URL requestUrl(String endpoint) {
        try {
            return URI.create(endpoint + "/acquire/orders").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String requestMethod() {
        return "POST";
    }

    @Override
    public Class<CreateAcquireOrderResponse> responseType() {
        return CreateAcquireOrderResponse.class;
    }

    public String getReferenceOrderNo() {
        return referenceOrderNo;
    }

    public String getTitle() {
        return title;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public CreateAcquireOrderRequest setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public GWaasAcquireMethod getAcquireMethod() {
        return acquireMethod;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public CreateAcquireOrderRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getSuccessCallbackUrl() {
        return successCallbackUrl;
    }

    public CreateAcquireOrderRequest setSuccessCallbackUrl(String successCallbackUrl) {
        this.successCallbackUrl = successCallbackUrl;
        return this;
    }

    public String getCancelCallbackUrl() {
        return cancelCallbackUrl;
    }

    public CreateAcquireOrderRequest setCancelCallbackUrl(String cancelCallbackUrl) {
        this.cancelCallbackUrl = cancelCallbackUrl;
        return this;
    }

    public Instant getExpireTime() {
        return expireTime;
    }

    public CreateAcquireOrderRequest setExpireTime(Instant expireTime) {
        this.expireTime = expireTime;
        return this;
    }
}
