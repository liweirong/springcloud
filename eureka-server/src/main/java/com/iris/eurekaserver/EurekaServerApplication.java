package com.iris.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

public class EurekaServerApplication {

    @EnableAutoConfiguration
    @EnableEurekaServer // 开启eureka server功能
    public static class EurekaServerConfiguration {
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerConfiguration.class, args);
    }
}
