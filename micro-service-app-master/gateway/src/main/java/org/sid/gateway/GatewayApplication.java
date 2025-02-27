package org.sid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args);
    }

    // @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                //lb => load balancer, il creer equilibrage de charge selon combien d'instance de CUSTOMER-SERVICE
//                .route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
//                .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
//                .build();
//
//    }

    // localhost:8888/CUSTOMER-SERVICE/customers   on peut contacter le micro service avec le nom via gateway
    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(
            ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
