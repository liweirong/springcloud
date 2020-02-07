# spring cloud sleuth
服务链路追踪 在分布式的系统中提供服务链路追踪的解决方案

```
依次启动 
eureka-server
zikpin-server
user-service
gateway-service
访问 http://localhost:5000/user-api/user/hi  
        得到响应 - I'm from user-service module
        
访问zipkin展示页 http://127.0.0.1:9411
展示server搜集的链路数据及服务的依赖关系

```

