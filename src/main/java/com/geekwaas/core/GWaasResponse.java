package com.geekwaas.core;

import com.geekwaas.core.entity.GWaasBizResult;

public interface GWaasResponse {

    GWaasBizResult getBizResult();

    void setRawResponse(String rawResponse);

    String getRawResponse();
}
