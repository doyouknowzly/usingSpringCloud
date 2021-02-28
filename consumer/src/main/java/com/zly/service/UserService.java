package com.zly.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zly.service.rpc.RpcUserInterface;
import com.zly.service.rpc.RpcUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private RpcUserService rpcUserService;

    @Resource
    private RpcUserInterface rpcUserInterface;

    @HystrixCommand(fallbackMethod = "fallback")
    public String login(String userName, String password){
        return rpcUserService.login(userName, password);
    }

    //Feign自带Hystrix,默认关闭
    //下面这个注解是没有通过Feign内置的Hystrix的用法
    //@HystrixCommand不能放到interface的方法上
    @HystrixCommand(fallbackMethod = "fallback")
    public String loginWithFeign(String userName, String password){
        return rpcUserInterface.rpcLogin(userName, password);
    }

    public String fallback(String userName, String password){
        return "fallback can only say hi.";
    }
}
