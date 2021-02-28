package com.zly.service.fallback;

import com.zly.service.rpc.RpcUserInterface;
import org.springframework.stereotype.Service;

@Service
public class RpcUserInterfaceFallBack implements RpcUserInterface {
    public String rpcLogin(String userName, String password) {
        return "feign fallback";
    }
}
