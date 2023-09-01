package com.geekwaas.core;

import java.util.Properties;

public class GWaasClientConfig {
    private String endpoint;
    private String merchantId;
    private String merchantPrivateKey;
    private String gwaasPublicKey;

    public static GWaasClientConfig loadProperties(Properties prop) {
        GWaasClientConfig config = new GWaasClientConfig();
        config.setEndpoint(loadProperty(prop, "gwaas.endpoint"));
        config.setMerchantId(loadProperty(prop,"gwaas.merchant-id"));
        config.setMerchantPrivateKey(loadProperty(prop,"gwaas.merchant-private-key"));
        config.setGwaasPublicKey(loadProperty(prop,"gwaas.gwaas-public-key"));
        return config;
    }

    private static String loadProperty(Properties prop, String configKey) {
        String propValue = prop.getProperty(configKey);
        if (propValue == null) {
            throw new RuntimeException(configKey + " required in configuration");
        }
        return propValue;
    }

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
