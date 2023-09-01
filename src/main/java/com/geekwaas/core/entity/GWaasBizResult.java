package com.geekwaas.core.entity;

public class GWaasBizResult {
    private BizCode bizCode;
    private String errorCode;
    private String message;

    public BizCode getBizCode() {
        return bizCode;
    }

    public GWaasBizResult setBizCode(BizCode bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public GWaasBizResult setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GWaasBizResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
