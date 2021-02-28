#本项目旨在学习、记录、备忘spring cloud的日常使用

# 一、组件介绍
### 1.Eureka：注册中心，服务发现
- Eureka Client  
    consumer\provider服务中都包含 1个Eureka Client  
- Eureka Server  
    独立的注册中心，单独部署，充当"中间人"的角色,类似于zookeeper  
    默认情况下Eureka Server也是1个Eureka Client  

### 2.RestTemplate： 微服务间调用的底层HTTP框架
  
### 3.Ribbon： 负载均衡

### 4.OpenFeign： 映射http请求和java方法, 实现远程调用

### 5.Hystrix： 熔断、降级

### 6.Zuul: 网关（鉴权、路由、限流、监控）

### 7.Spring Cloud Config: 动态更新配置文件，类似携程的Apollo


## 参考资料
1. [方志鹏博客<<史上最简单的 SpringCloud 教程>>](https://forezp.blog.csdn.net/article/details/70148833)