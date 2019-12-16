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
    
 通过Eureka Client的Cancel、心跳监控、renew等方式来维护该服务提供的信息以*确保该服务可用以及服务的更新*。
    
```

```
服务注册：当client启动时会将自身的服务信息发送到server
    其实过程非常简单，com.netfix.discovery包下有一个DiscoryClient类
    该类是个单例方法，包含了注册方法，实现了EurekaClient接口
    

```
```
为什么eureka client获取服务实例那么慢
    1.eureka client的注册延迟：默认40s
    2.eureka server的响应缓存：server维护每30s更新一次缓存，可修改，所以刚更新的配置可能不会立即出现
    3.eureka client的缓存：client保留注册表信息的缓存，该缓存30s更新一次
    4.loadBalance缓存：ribbon的负载均衡器从本地的client获取注册表信息，ribbon本身还维护了缓存，以避免每个请求都从client获取，缓存30s刷新一次（可配置）
  综上，一个新注册的实例，默认延迟40s向服务中心注册，所以不能马上被server发现
          另外，刚注册的client也不能立即被其他服务调用，调用方由于各种换缓存导致没有及时获取最新信息

```