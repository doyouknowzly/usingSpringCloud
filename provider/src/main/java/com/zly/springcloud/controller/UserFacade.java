package com.zly.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserFacade {

    @GetMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        return "success";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
