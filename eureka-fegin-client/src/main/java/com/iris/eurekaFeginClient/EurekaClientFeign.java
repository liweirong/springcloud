package com.iris.eurekaFeginClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 简单的feign client
 * @author iris
 * @date 2019/12/22
 */

@FeignClient(value = "eureka-client",configuration = FeignClient.class)
public interface EurekaClientFeign {

    @GetMapping(value="/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
