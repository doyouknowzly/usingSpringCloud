package com.zly.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zly.service.UserService;
import com.zly.service.rpc.RpcUserInterface;
import com.zly.service.rpc.RpcUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
public class HomeController {


    @Resource
    private UserService userService;

    @RequestMapping("/login")
    //fallback方法参数和主方法参数要一致, 否则会报错
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        String rpcResult = userService.login(userName, password);
        return rpcResult;
    }

    @RequestMapping("/login/feign")

    public String loginWithFeign(@RequestParam("userName") String userName, @RequestParam("password") String password){
        String rpcResult = userService.loginWithFeign(userName, password);
        return rpcResult;
    }

    @RequestMapping("/hi")
    public String sayhi(String userName, String password){
        return "hi";
    }
}
