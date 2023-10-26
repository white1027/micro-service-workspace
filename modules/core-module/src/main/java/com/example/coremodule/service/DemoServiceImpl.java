package com.example.coremodule.service;

import com.example.library.common.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
