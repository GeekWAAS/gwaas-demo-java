package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasResponse;
import com.geekwaas.core.entity.AcquireNewOrderInfo;
import com.geekwaas.core.entity.GWaasBizResult;

public class CreateAcquireOrderResponse implements GWaasResponse {
    private String rawResponse;
    private GWaasBizResult bizResult;
    private AcquireNewOrderInfo order;
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

    public CreateAcquireOrderResponse setBizResult(GWaasBizResult bizResult) {
        this.bizResult = bizResult;
        return this;
    }

    public AcquireNewOrderInfo getOrder() {
        return order;
    }

    public CreateAcquireOrderResponse setOrder(AcquireNewOrderInfo order) {
        this.order = order;
        return this;
    }
}
