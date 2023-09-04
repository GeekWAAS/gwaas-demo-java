package com.geekwaas.example.servlets;

public class DemoServletResponse {
    private String requestUrl;
    private String requestMethod;
    private String requestBody;
    private String responseBody;

    private Object callbackData;

    public String getRequestUrl() {
        return requestUrl;
    }

    public DemoServletResponse setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public DemoServletResponse setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public DemoServletResponse setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public DemoServletResponse setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public Object getCallbackData() {
        return callbackData;
    }

    public DemoServletResponse setCallbackData(Object callbackData) {
        this.callbackData = callbackData;
        return this;
    }
}
