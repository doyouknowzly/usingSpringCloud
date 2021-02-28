package com.zly.controller;


import com.zly.service.RpcUserInterface;
import com.zly.service.RpcUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
public class HomeController {


    @Resource
    private RpcUserService userService;

    @Resource
    private RpcUserInterface rpcUserInterface;

    @RequestMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        String rpcResult = userService.login(userName, password);

        return rpcResult;
    }

    @RequestMapping("/login/feign")
    public String loginWithFeign(@RequestParam("userName") String userName, @RequestParam("password") String password){
        String rpcResult = rpcUserInterface.rpcLogin(userName, password);

        return rpcResult;
    }

    @RequestMapping("/hi")
    public String sayhi(){
        return "hi";
    }
}
