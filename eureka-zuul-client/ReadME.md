# spring cloud - Eureka zuul
```
服务启动
启动之后访问

http://127.0.0.1:5000/hiapi/hi/asd
    返回：   eureka client :eureka-client:port:[8763/8763] asd
            eureka client :eureka-client:port:[8764/8764] asd
            进行了负载均衡
http://127.0.0.1:5000/feignapi/hiFeign/asd


zuul采用的是异步阻塞模型，性能比ngnix差，由于zuul可以和ngnix相互配合，无缝集成，zuul很容易就实现负载均衡、智能路由、熔断器等
大多情况下zuul是以集群的方式存在的，
zuul横向扩展能力很好，负载高时可以通过添加实例来解决
```

