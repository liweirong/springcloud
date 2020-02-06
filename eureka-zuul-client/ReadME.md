# spring cloud - Eureka zuul
```
服务启动
启动之后访问

http://127.0.0.1:5000/hiapi/hi/asd
    返回：   eureka client :eureka-client:port:[8763/8763] asd
            eureka client :eureka-client:port:[8764/8764] asd
            进行了负载均衡
http://127.0.0.1:5000/feignapi/hiFeign/asd

```

