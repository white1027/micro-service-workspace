package com.example.usermodule.service;

import com.example.library.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String getUserByName(String name) {
        return "User:" + name;
    }
}
