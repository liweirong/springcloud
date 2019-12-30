package com.iris.eurekaFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 简单的feign client
 * @author iris
 * @date 2019/12/22
 */

@FeignClient(name = "eureka-client",url = "http://127.0.0.1:8761/eureka", configuration = FeignClient.class)
public interface EurekaClientFeign {

    @GetMapping(value="/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
