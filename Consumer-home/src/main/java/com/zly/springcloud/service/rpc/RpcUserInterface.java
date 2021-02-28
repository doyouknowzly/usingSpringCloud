package com.zly.springcloud.service.rpc;

import com.zly.springcloud.service.fallback.RpcUserInterfaceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eurekaprovider", fallback = RpcUserInterfaceFallBack.class)
//如果同时和自己集成的@HystrixCommand注解一起使用，@HystrixCommand的优先级比较低
public interface RpcUserInterface {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    String rpcLogin(@RequestParam("userName") String userName, @RequestParam("password") String password);
}
