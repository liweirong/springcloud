# spring cloud - config
```
服务启动
启动之后访问

1从本地读取配置文件 
resources\shared\config-client-dev.yml
请求http://localhost:9001/foo

2从远程git仓库读取配置文件（https://github.com/liweirong/document/blob/master/config-client-dev.yml）
 请求http://localhost:9002/foo
 
3 高可用集群方式，server多开注册到eureka上，单个client重复启动可以看到
如下信息
    Fetching config from server at : http://localhost:9000/
    Fetching config from server at : http://localhost:9001/
交替出现，并做了负载均衡
```

