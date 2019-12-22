package com.iris.eurekaFeginClient.server;

import com.iris.eurekaFeginClient.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author iris
 * @date 2019/12/23
 */
@Service
public class HiService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name ){
       return  eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
