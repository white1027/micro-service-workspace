package com.example.core.gateway.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acc")
public class LoginController {

    @PostMapping("login")
    public SaResult doLogin(String name, String pwd) {
        if("gary".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            return SaResult.ok("Login Successes");
        }
        return SaResult.error("Login Failed");
    }

    @GetMapping("login")
    public SaResult isLogin() {
        return SaResult.ok("Is Login：" + StpUtil.isLogin());
    }

    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}
