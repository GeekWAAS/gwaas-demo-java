package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasResponse;
import com.geekwaas.core.entity.AcquireNewOrderInfo;
import com.geekwaas.core.entity.GWaasBizResult;

public class CreateAcquireOrderResponse implements GWaasResponse {
    private GWaasBizResult bizResult;
    private AcquireNewOrderInfo order;
    @Override
    public GWaasBizResult getBizResult() {
        return bizResult;
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
