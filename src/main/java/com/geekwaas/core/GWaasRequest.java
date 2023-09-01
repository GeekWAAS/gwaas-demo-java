package com.geekwaas.core;

import java.net.URL;

public interface GWaasRequest<E extends GWaasResponse> {

    URL requestUrl(String endpoint);

    String requestMethod();

    Class<E> responseType();

    default boolean hasBody() {
        return "POST".equals(requestMethod()) || "PUT".equals(requestMethod());
    }
}
