package com.iris.eurekaClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iris
 * @date 2019/12/12
 */
@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private int port;
    /**
     * eureka client :eureka-client:port:0 asd
     * 如果是动态的port则不行，需要启动时动态的加载，不然总是0
     */
    private final Environment environment;

    public EurekaClientController(Environment environment) {
        this.environment = environment;
    }

    String getPort() {
        return environment.getProperty("local.server.port");
    }

    @Value("${spring.application.name}")
    private String name;


    @GetMapping("/hi/{message}")
//    @HystrixCommand(fallbackMethod = "homeErr")
    public String home(@PathVariable String message) {
//        if(message.contains("1")){
//            int i = 1/0;
//        }
        return "eureka client :" + name + ":port:[" + getPort() + "/" + port + "]\n" + message;
    }

    public String homeErr(@PathVariable String message) {
        return "ERROR :" + name + ":port:[" + getPort() + "/" + port + "] ERROR!";
    }
}
