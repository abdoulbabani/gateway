package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
 // @Bean
 //Configuratio manuelle avec les service
 /* RouteLocator routelocator (RouteLocatorBuilder builder ){
        return builder.routes()
                .route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE")//.id("r1")
                )
                .route((r)->r.path(  "/products/**").uri("lb://PRODUCT-SERVICE")//.id("r2 ")
                         )

                .build();
    }*/
    //Configuratio automatique avec les differents service
@Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(
        ReactiveDiscoveryClient rdc,
        DiscoveryLocatorProperties properties){
                return new DiscoveryClientRouteDefinitionLocator(rdc,properties);

    }
}
