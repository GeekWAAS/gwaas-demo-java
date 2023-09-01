package com.geekwaas.example.utils;

import jakarta.servlet.http.HttpServletRequest;

public class HttpUtils {
    public static String resolveRequestHost(HttpServletRequest request) {
        StringBuilder hostBuilder = new StringBuilder();
        String proto = defaultString(request.getHeader("X-Forwarded-Proto"), request.getProtocol());
        hostBuilder.append(proto).append("://");
        String serverName = defaultString(request.getHeader("X-Forwarded-Host"), request.getHeader("Host"), request.getServerName());
        hostBuilder.append(serverName);
        String port = defaultString(request.getHeader("X-Forwarded-Port"), String.valueOf(request.getServerPort()));
        if ("http".equals(proto) && "80".equals(port)){
            port = null;
        } else if ("https".equals(proto) && "443".equals(port)) {
            port = null;
        }
        if (port!=null){
            hostBuilder.append(":").append(port);
        }
        return hostBuilder.toString();
    }

    private static String defaultString(String... strings) {
        for (String str : strings) {
            if (str != null) {
                return str;
            }
        }
        return null;
    }
}
