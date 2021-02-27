package com.zly.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Configuration
public class RpcUserService {


    @Resource
    private RestTemplate restTemplate;

    //这个类是spring cloud负载均衡的标准， Ribbon遵循了这个标准实现；
    //如果不使用Ribbon, 总得有其他负载均衡器实现这个
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Bean
    @LoadBalanced
    //@LoadBalanced就是使用Ribbon进行负载均衡，选中目标Service的一个实例
    public RestTemplate buildRestTemplate(){
        return new RestTemplate();
    }

    public String login(String userName, String password){
        ServiceInstance serviceInstance = loadBalancerClient.choose("userfacade");
        String url = "http://" + "eurekaProvider" + "/login?userName=" +userName +"&password="+password;
        String result = restTemplate.getForObject(
                url, String.class) + " from consumer";
        return result;
    }
}
