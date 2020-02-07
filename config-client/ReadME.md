# spring cloud - config client / Bus
```
服务启动
启动之后访问
http://localhost:9001/foo 
9001为server中配置的dev端口
访问接口可以得到server中设置的变量值 - config server version 1
 
```
```
引入bus刷新配置（只需改造client） 
如果有几十个微服务，每个微服务又是多实例，更改配置时需要重启很多微服务非常麻烦
bus的一个功能就是让过程变得简单
需要安装rabbitMQ
通过消息总线更改配置


开启多个client实例
页面访问http://localhost:9001/foo 
修改配置后通过postman等工具发送post请求：http://localhost:9001/bus/refresh
其他服务实例也会刷新配置
刷新的api也可以指定服务，即使用destination参数，例如
/bus/refresh?destination=eureka-client:**   即刷新服务名为eureka-clent的所有服务实例
```

