package com.iris.eurekaFeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 开启feign client功能
public class EurekaFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApplication.class, args);
    }

}
