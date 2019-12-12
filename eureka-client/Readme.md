# spring cloud生态② - Eureka Client
```
源码解析
eureka基本概念：
1）Register-服务注册
    当client向server注册时，client提供自身元数据，如ip、port、主页地址等
2）Renew-服务续约
    client默认会30s向server发送心跳来进行服务续约，告知依旧可用，没有故障，正常情况下90s没收到client心跳，会把client从注册列表中删除
3）Fetch registries-获取服务注册列表信息
    client从server获取服务注册信息并缓存到本地，该注册信息30s更新一次
4）Cancel-服务下线
    client在程序下线时可以发送下线请求，发送完后客户端实例信息会从server的注册列表中剔除，下线请求不会自动完成，需要在程序关闭时调用
    DiscoveryManager.getInstance().shutdownComponent()
5）Eviction-服务剔除
    90s没收到心跳则server会将服务实例从注册列表中删除，即服务剔除
```

