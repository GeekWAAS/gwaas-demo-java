package com.geekwaas.core.acquire;

import com.geekwaas.core.GWaasRequest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CheckOrderStatusRequest implements GWaasRequest<CheckOrderStatusResponse> {
    private final String referenceOrderNo;

    public CheckOrderStatusRequest(String referenceOrderNo) {
        this.referenceOrderNo = referenceOrderNo;
    }

    @Override
    public URL requestUrl(String endpoint) {
        try {
            return URI.create(endpoint + "/acquire/orders/" + referenceOrderNo).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String requestMethod() {
        return "GET";
    }

    @Override
    public Class<CheckOrderStatusResponse> responseType() {
        return CheckOrderStatusResponse.class;
    }
}
