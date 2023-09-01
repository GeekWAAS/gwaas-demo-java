package com.geekwaas.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class NotifyServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream in = req.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String requestBody = reader.lines().collect(Collectors.joining());
            System.out.println("received notify request to " + req.getPathInfo() + ": " + requestBody);
            logger.info("received notify request to {}: {}", req.getPathInfo(), requestBody);
        }
    }


}
