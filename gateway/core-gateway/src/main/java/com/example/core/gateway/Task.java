package com.example.core.gateway;

import com.example.library.common.model.domain.User;
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
            logger.info("UserService.createUser");
            var user = User.builder().name("Gary").age(40).build();
            user = userService.createUser(user);
            while (true) {
                try {
                    logger.info("DemoService.sayHello result ======> " + demoService.sayHello("world"));
                    // 測試三種不同的類別是否可以正常使用
                    logger.info("UserService.getRecordUserByName result ======> " + userService.findRecordUserById(user.getId()).toString());
                    logger.info("UserService.getLombokUserByName result ======> " + userService.findLombokUserById(user.getId()).toString());
                    logger.info("UserService.getLombokBuilderUserByName result ======> " + userService.findLombokBuilderUserById(user.getId()).toString());
                    logger.info("UserService.findUserBySearchParam result ======> " + userService.findUserBySearchParam(User.builder().name("Gary").build()).toString());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    logger.error("Get data error", e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}