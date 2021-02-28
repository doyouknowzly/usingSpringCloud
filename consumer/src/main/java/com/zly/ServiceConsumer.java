package com.zly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.CountDownLatch;

@EnableDiscoveryClient
//@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心
@EnableFeignClients
@EnableHystrix
@SpringBootApplication(scanBasePackages = "com.zly")
public class ServiceConsumer {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SpringApplication.run(ServiceConsumer.class, args);
        System.out.println("consumer startup");
        countDownLatch.await();
    }
}
