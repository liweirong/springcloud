package com.iris.eurekaFeignClient.hystrix;

import com.iris.eurekaFeignClient.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * 熔断器的逻辑处理类，写熔断的具体逻辑
 *
 * @author iris
 * @date 2019/12/31
 */
@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi " + name + " sorry, HiHystrix error!";
    }
}
