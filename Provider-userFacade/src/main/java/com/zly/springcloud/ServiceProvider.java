package com.zly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.CountDownLatch;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.zly")
public class ServiceProvider {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SpringApplication.run(ServiceProvider.class, args);
        System.out.println("provider startup");
        countDownLatch.await();
    }
}
