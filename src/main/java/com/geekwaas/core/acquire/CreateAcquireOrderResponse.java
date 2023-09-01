package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasResponse;
import com.geekwaas.core.entity.AcquireOrderInfo;
import com.geekwaas.core.entity.GWaasBizResult;

public class CreateAcquireOrderResponse implements GWaasResponse {
    private GWaasBizResult bizResult;
    private AcquireOrderInfo order;
    @Override
    public GWaasBizResult getBizResult() {
        return bizResult;
    }

    public CreateAcquireOrderResponse setBizResult(GWaasBizResult bizResult) {
        this.bizResult = bizResult;
        return this;
    }

    public AcquireOrderInfo getOrder() {
        return order;
    }

    public CreateAcquireOrderResponse setOrder(AcquireOrderInfo order) {
        this.order = order;
        return this;
    }
}
