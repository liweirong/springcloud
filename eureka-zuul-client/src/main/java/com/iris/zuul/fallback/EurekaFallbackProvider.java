package com.iris.zuul.fallback;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 关闭所有eureka-client实例后再进行路由返回【 oh zuul! error , i'm the fallback】
 * @author iris
 * @date 2020/2/6
 */
@Component
public class EurekaFallbackProvider implements FallbackProvider {
    /**
     * 指定熔断功能应用哪些路由的服务
     * 这里返回的是回退将用到的路由
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "eureka-client"; // 需要所有的路由加熔断则改成 *
    }


    /**
     * 进入熔断功能时执行的逻辑
     * 根据执行失败的原因提供回退响应
     *
     * @param route The route the fallback is for
     * @param cause cause of the main method failure, may be <code>null</code>
     * @return the fallback response
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            /**
             * 失败返回
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("oh zuul! error , i'm the fallback".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
