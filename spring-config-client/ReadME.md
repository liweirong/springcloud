# spring cloud生态
```
Eureka是一个用于服务注册与发现的组件
Eureka分为Eureka Server和Eureka Client
Eureka基本架构包含三个角色：
    Register Service:服务注册中心（Eureka Server）提供服务注册和发现
    Provide Service :服务提供者(Eureka Client) 提供服务
    Consume Service :服务消费者(Eureka Client) 消费服务
    
①启动eureka server
    访问http://localhost:8761/
    ![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)
http://localhost:8761/eureka/apps
缺点：xml客户端会缓存所有数据，不会gc，很容易造成fullGc（规模越大，占有内存也大）
服务注册
带参数选择启动：
program arguments: --spring.profiles.active=zookeeper

```

