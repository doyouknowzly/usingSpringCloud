package com.zly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages = "com.zly")
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayZuul {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SpringApplication.run(GatewayZuul.class, args);
        System.out.println("zuul startup");
        countDownLatch.await();
    }
}
