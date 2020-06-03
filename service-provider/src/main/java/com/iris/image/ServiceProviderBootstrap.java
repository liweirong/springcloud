package com.iris.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAutoConfiguration
@ComponentScan
//@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableAspectJAutoProxy //激活aop
public class ServiceProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderBootstrap.class, args);
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("world",
//                        r -> r.path("/w")
//                                .uri("http://127.0.0.1:8080/world"))
//                .build();
//    }
}
