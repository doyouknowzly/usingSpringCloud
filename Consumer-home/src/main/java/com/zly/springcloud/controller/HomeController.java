package com.zly.springcloud.controller;


import com.zly.springcloud.service.UserService;
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
