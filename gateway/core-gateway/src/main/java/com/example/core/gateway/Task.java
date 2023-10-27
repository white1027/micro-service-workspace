package com.example.core.gateway;

import com.example.library.common.service.DemoService;
import com.example.library.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Task implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @DubboReference
    private DemoService demoService;

    @DubboReference
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Thread start");
        new Thread(() -> {
            while (true) {
                try {
                    logger.info("DemoService.sayHello result ======> " + demoService.sayHello("world"));
                    logger.info("UserService.getRecordUserByName result ======> " + userService.getRecordUserByName("world").toString());
                    logger.info("UserService.getLombokUserByName result ======> " + userService.getLombokUserByName("world").toString());
                    logger.info("UserService.getLombokBuilderUserByName result ======> " + userService.getLombokBuilderUserByName("world").toString());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    logger.error("Get data error", e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}