package com.geekwaas.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.geekwaas.core.entity.GWaasBizResult;
import com.geekwaas.core.security.RSA2Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GWaasClient {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final GWaasClientConfig clientConfig;
    private final ObjectMapper objectMapper;

    public GWaasClient(GWaasClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    public <E extends GWaasResponse> E request(GWaasRequest<E> request) throws IOException {
        URL url = request.requestUrl(clientConfig.getEndpoint());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(request.requestMethod());
        con.setDoInput(true);
        con.setUseCaches(false);


        String payload = request.hasBody() ? "" : objectMapper.writeValueAsString(request);
        makeSignature(con, url, request.requestMethod(), payload);
        if (request.hasBody()) {
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(request.hasBody());
            con.connect();
            try (OutputStream out = con.getOutputStream()) {
                out.write(payload.getBytes(StandardCharsets.UTF_8));
                out.flush();
            }
        } else {
            con.connect();
        }
        int responseCode = con.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            try (InputStream in = con.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String response = reader.lines().collect(Collectors.joining());
                String merchantId = con.getHeaderField("X-Merchant-Id");
                if (!clientConfig.getMerchantId().equals(merchantId)) {
                    throw new RuntimeException("Invalid response");
                }
                String authorization = con.getHeaderField("Authorization");
                Map<String, String> authorizationParts = Arrays.stream(authorization.split("=")).map(String::strip)
                        .collect(HashMap::new, (map, part) -> {
                            String[] args = part.split("=");
                            if (args.length == 2) {
                                map.put(args[0], args[1]);
                            }
                        }, Map::putAll);

                verifySignature(url, request.requestMethod(), authorizationParts, response);
                return objectMapper.readValue(response, request.responseType());
            }
        } else {
            try (InputStream in = con.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String response = reader.lines().collect(Collectors.joining());
                GWaasBizResult error = objectMapper.readValue(response, GWaasBizResult.class);
                logger.error("{} - {} - {}", error.getBizCode(), error.getErrorCode(), error.getMessage());
                throw new RuntimeException(String.format("Request GWaas failed: %s - %s - %s", error.getBizCode(), error.getErrorCode(), error.getMessage()));
            }
        }
    }

    private void verifySignature(URL url, String method, Map<String, String> authorizationParts, String response) {
        String algorithm = authorizationParts.get("algorithm");
        if (!"RSA2".equals(algorithm)) {
            throw new RuntimeException("Incorrect signature algorithm");
        }
        String timestamp = authorizationParts.get("time");
        if (Math.abs(Long.decode(timestamp) - System.currentTimeMillis()) > Duration.ofMinutes(5).toMillis()) {
            throw new RuntimeException("Response signature expired");
        }
        String path = url.getPath();
        if (url.getQuery() != null) {
            path += "?" + url.getQuery();
        }
        String signBase = String.format("%s %s\n%s\n%s\n%s\n", method, path, clientConfig.getMerchantId(), timestamp, response);
        String signature = authorizationParts.get("signature");
        if (signature == null) {
            throw new RuntimeException("Response signature verify failed");
        }
        if (!RSA2Signature.verify(signBase, clientConfig.getGwaasPublicKey(), signature)) {
            throw new RuntimeException("Response signature verify failed");
        }
    }

    private void makeSignature(HttpURLConnection con, URL url, String method, String payload) {
        String path = url.getPath();
        if (url.getQuery() != null) {
            path += "?" + url.getQuery();
        }
        long timestamp = System.currentTimeMillis();
        String signBase = String.format("%s %s\n%s\n%s\n%s\n", method, path, clientConfig.getMerchantId(), timestamp, payload);
        logger.debug("Requesting sign base = {}", signBase);
        String signature = RSA2Signature.sign(signBase, clientConfig.getMerchantPrivateKey());
        con.setRequestProperty("X-Merchant-Id", clientConfig.getMerchantId());
        String authorization = String.format("algorithm=RSA2,time=%s,signature=%s", timestamp, URLEncoder.encode(signature, StandardCharsets.UTF_8));
        con.setRequestProperty("Authorization", authorization);
    }
}
