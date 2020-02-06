package com.iris.eurekaFeignClient.controller;

import com.iris.eurekaFeignClient.server.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iris
 * @date 2019/12/23
 */
@RestController
public class HiController {
    @Autowired
    private HiService hiService;


    /**
     * 依次启动server、client、feign
     * 访问 http://localhost/{port}/hystrix.stream 会显示断路器的数据指标
     * 访问 http://localhost/{port}/hystrix 会显示断路器的数据指标
     * http://localhost:51562/actuator/hystrix.stream
     *
     * @param name
     * @return
     */
    @GetMapping("/hiFeign/{name}")
    public String sayHi(@PathVariable String name) {
        return hiService.sayHi(name);
    }

}
