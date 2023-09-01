package com.geekwaas.core;

public class GWaasErrorResponse {
    private BizCode bizCode;
    private String errorCode;
    private String message;

    public BizCode getBizCode() {
        return bizCode;
    }

    public GWaasErrorResponse setBizCode(BizCode bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public GWaasErrorResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GWaasErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
