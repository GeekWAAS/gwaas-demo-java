package com.geekwaas.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.geekwaas.core.GWaasClient;
import com.geekwaas.core.GWaasClientConfig;
import com.geekwaas.example.servlets.NewOrderServlet;
import com.geekwaas.example.servlets.NotifyServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeekWaasApplication {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ResourceHandler staticResourceHandler = new ResourceHandler();
        staticResourceHandler.setBaseResource(Resource.newClassPathResource("static"));
        staticResourceHandler.getWelcomeFile("/index.html");

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/service");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{staticResourceHandler, context});
        server.setHandler(handlerList);

        bootstrap(context);

        server.start();
        server.join();
    }

    private static void bootstrap(ServletContextHandler context) throws IOException {
        GWaasClient client = initGwaasClient();
        ObjectMapper objectMapper = new ObjectMapper()
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .registerModule(new JavaTimeModule());
        context.addServlet(new ServletHolder(new NewOrderServlet(objectMapper, client)), "/acquire-orders");
        context.addServlet(new ServletHolder(new NotifyServlet()),"/orders/**");
    }

    private static GWaasClient initGwaasClient() throws IOException {
        try (InputStream in = GeekWaasApplication.class.getClassLoader().getResourceAsStream("gwaas-config.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            GWaasClientConfig config = GWaasClientConfig.loadProperties(prop);
            return new GWaasClient(config);
        }
    }
}
