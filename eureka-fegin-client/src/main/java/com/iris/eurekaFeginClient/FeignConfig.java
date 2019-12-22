package com.iris.eurekaFeginClient;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 配置类，注入retryer后，feign在远程调用失败后会进重试
 * @author iris
 * @date 2019/12/22
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
