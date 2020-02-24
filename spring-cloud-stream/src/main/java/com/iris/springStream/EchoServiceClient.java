package com.iris.springStream;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-provider")
public interface EchoServiceClient {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable String message);
}
