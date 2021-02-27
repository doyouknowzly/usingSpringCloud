package com.zly.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableEurekaServer

public class EurekaServerApplication {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println("EurekaServer startup");
        countDownLatch.await();
    }
}
