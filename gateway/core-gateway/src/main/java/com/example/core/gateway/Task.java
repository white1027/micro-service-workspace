package com.example.core.gateway;

import com.example.library.common.service.DemoService;
import com.example.library.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private DemoService demoService;

    @DubboReference
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
                    System.out.println(new Date() + " Receive result ======> " + userService.getUserByName("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}