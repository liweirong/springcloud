package com.iris.gatewayService.filter;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 网关的核心是filter
 * 需求： 在链路请求上加入请求的操作人
 *
 * @author iris
 * @date 2020/2/8
 */
@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.currentSpan().tag("operator", "iris");
        System.out.println("gateway-service loggerFilter :" + tracer.currentSpan());
        return null;
    }
}
