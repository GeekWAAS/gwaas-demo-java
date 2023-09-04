package com.geekwaas.example.servlets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekwaas.core.GWaasClient;
import com.geekwaas.core.acquire.CheckOrderStatusRequest;
import com.geekwaas.core.acquire.CheckOrderStatusResponse;
import com.geekwaas.core.acquire.CreateAcquireOrderRequest;
import com.geekwaas.core.acquire.CreateAcquireOrderResponse;
import com.geekwaas.core.entity.GWaasAcquireMethod;
import com.geekwaas.example.utils.HttpUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class NewOrderServlet extends HttpServlet {
    private final ObjectMapper objectMapper;
    private final GWaasClient client;

    public NewOrderServlet(ObjectMapper objectMapper, GWaasClient client) {
        this.objectMapper = objectMapper;
        this.client = client;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream in = req.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String requestBody = reader.lines().collect(Collectors.joining());
            JsonNode body = objectMapper.readTree(requestBody);
            String referenceOrderNo = UUID.randomUUID().toString();
            String title = "Test order";
            String orderDesc = "Test order description";
            String currency = "USD";
            BigDecimal amount = body.get("amount").decimalValue();
            String acquireMethod = body.get("acquireMethod").asText();
            String localhost = HttpUtils.resolveRequestHost(req);
            String notifyCallback = localhost + "/service/orders/" + referenceOrderNo + "/notify";
            String successCallback = localhost + "/result.html?order=" + referenceOrderNo;
            String cancelCallback = localhost + "/result.html?order=" + referenceOrderNo;
            CreateAcquireOrderRequest request = new CreateAcquireOrderRequest(referenceOrderNo, title, currency, amount, GWaasAcquireMethod.valueOf(acquireMethod))
                    .setOrderDesc(orderDesc)
                    .setNotifyUrl(notifyCallback)
                    .setSuccessCallbackUrl(successCallback)
                    .setCancelCallbackUrl(cancelCallback);
            DemoServletResponse servletResp = new DemoServletResponse();
            servletResp.setRequestBody(client.serializeRequestBody(request))
                    .setRequestUrl(client.getUrl(request).toString())
                    .setRequestMethod(request.requestMethod());
            CreateAcquireOrderResponse orderResponse = client.request(request);
            servletResp.setResponseBody(orderResponse.getRawResponse());
            servletResp.setCallbackData(Map.of("cashierUrl", orderResponse.getOrder().getCashierUrl()));
            resp.setHeader("Content-Type", "application/json");
            try (Writer out = resp.getWriter()) {
                out.write(objectMapper.writeValueAsString(servletResp));
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        CheckOrderStatusRequest request = new CheckOrderStatusRequest(orderId);
        CheckOrderStatusResponse response = client.request(request);
        DemoServletResponse servletResp = new DemoServletResponse();
        servletResp.setRequestBody(client.serializeRequestBody(request))
                .setRequestUrl(client.getUrl(request).toString())
                .setRequestMethod(request.requestMethod())
                .setResponseBody(response.getRawResponse())
                .setCallbackData(response);
        resp.setHeader("Content-Type", "application/json");
        try (Writer out = resp.getWriter()) {
            out.write(objectMapper.writeValueAsString(servletResp));
        }
    }
}
