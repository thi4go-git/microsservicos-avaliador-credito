package com.dynns.cloudtecnologia.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/api/clientes/**").uri("lb://ms-cliente"))
                .route(r -> r.path("/api/cartoes/**").uri("lb://ms-cartao"))
                .route(r -> r.path("/api/avaliador/**").uri("lb://ms-avaliador"))
                .build();
    }


}
