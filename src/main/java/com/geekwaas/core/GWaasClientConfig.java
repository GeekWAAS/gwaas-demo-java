package com.geekwaas.core;

public class GWaasClientConfig {
    private String endpoint;
    private String merchantId;
    private String merchantPrivateKey;
    private String merchantPublicKey;
    private String gwaasPublicKey;

    public String getMerchantId() {
        return merchantId;
    }

    public GWaasClientConfig setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public GWaasClientConfig setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
        return this;
    }

    public String getMerchantPublicKey() {
        return merchantPublicKey;
    }

    public GWaasClientConfig setMerchantPublicKey(String merchantPublicKey) {
        this.merchantPublicKey = merchantPublicKey;
        return this;
    }

    public String getGwaasPublicKey() {
        return gwaasPublicKey;
    }

    public GWaasClientConfig setGwaasPublicKey(String gwaasPublicKey) {
        this.gwaasPublicKey = gwaasPublicKey;
        return this;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public GWaasClientConfig setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }
}
