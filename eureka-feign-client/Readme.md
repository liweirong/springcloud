# Getting Started

### Reference Documentation
多次访问http://localhost:8765/hi 
浏览器会轮流显示8762、8763端口的信息，说明feign client具有负载均衡的能力

```
feign作为一个伪java http客户端，feign不做任何的请求处理。通过注解生成reuqest模板，从而简化http api开发
开发人员可以使用注解方式定制request api模板。
在发送request请求前，feign通过注解的方式替换掉reuqest模板中的参数，生成真正的request，交给java http客户端处理
利用这种方式，开发者只需呀注重注解模板开发，而不用关心http本身，简化请求过程，使得http请求变得简单和容易理解。

源码分析
@FeignClient注解被以下三个注解修饰
    @Target(ElementType.TYPE) //注解作用目标在接口上
    @Retention(RetentionPolicy.RUNTIME) //该注解会在class字节码文件中存在，在运行时可以通过反射得到
    @Documented //注解将被包含在javadoc中

```
