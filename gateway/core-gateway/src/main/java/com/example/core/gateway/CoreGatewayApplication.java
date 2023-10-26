package com.example.core.gateway;

import com.example.library.common.Common;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CoreGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreGatewayApplication.class, args);
    }
}
