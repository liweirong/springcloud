package com.iris.eurekaFeignClient.controller;

import com.iris.eurekaFeignClient.server.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/hiFeign")
    public String sayHi(@RequestParam(defaultValue = "forezp",required = false) String name){
        return hiService.sayHi(name);
    }
}
