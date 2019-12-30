package com.iris.eurekaFeignClient.hystrix;

import com.iris.eurekaFeignClient.EurekaClientFeign;

/**
 * @author iris
 * @date 2019/12/31
 */
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi "+name +" sorry, HiHystrix error!";
    }
}
