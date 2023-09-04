package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasResponse;
import com.geekwaas.core.entity.AcquireOrderInfo;
import com.geekwaas.core.entity.GWaasBizResult;

public class CheckOrderStatusResponse implements GWaasResponse {
    private String rawResponse;
    private GWaasBizResult bizResult;
    private AcquireOrderInfo order;

    @Override
    public GWaasBizResult getBizResult() {
        return bizResult;
    }

    @Override
    public void setRawResponse(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    @Override
    public String getRawResponse() {
        return rawResponse;
    }

    public CheckOrderStatusResponse setBizResult(GWaasBizResult bizResult) {
        this.bizResult = bizResult;
        return this;
    }

    public AcquireOrderInfo getOrder() {
        return order;
    }

    public CheckOrderStatusResponse setOrder(AcquireOrderInfo order) {
        this.order = order;
        return this;
    }
}
