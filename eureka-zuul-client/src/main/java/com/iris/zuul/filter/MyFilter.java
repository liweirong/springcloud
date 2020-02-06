package com.iris.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 实现自定义过滤器
 * <p>
 * 依次发送
 * http://localhost:5000/hiapi/hi/ads
 * http://localhost:5000/hiapi/hi/ads?token=1
 *
 * @author iris
 * @date 2020/2/6
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 过滤的类型：有四种类型
     * <p>
     * ERROR_TYPE = "error";
     * POST_TYPE = "post";
     * PRE_TYPE = "pre";
     * ROUTE_TYPE = "route";
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 是表示过滤顺序 值越小越早执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否过滤逻辑，true则执行run方法，false则不执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体过滤逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        // 判断参数中是否带token，没有传则直接返回401
        String token = request.getParameter("token");
        System.out.println("token: " + token);
        if (token == null) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("zuul filter! token is empty!");
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
