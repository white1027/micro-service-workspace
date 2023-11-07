package com.example.core.gateway.security;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 指定 [攔截路由]
                .addInclude("/**")    /* 攔截所有path */
                // 指定 [放行路由]
                .addExclude("/favicon.ico")
                // 指定[認證方法]: 每次請求都會執行
                .setAuth(obj -> {
                    logger.info("---------- sa-token global auth");
                    // 註解掉下面這段就會讓 user 要進行驗證
//                    SaRouter.match("/user/**", StpUtil::checkLogin);
                })
                // 指定[異常攔截方法]：每次[認證方法]拋出異常都會執行
                .setError(e -> {
                    logger.error("---------- sa-token error ", e);
                    return SaResult.error(e.getMessage());
                });
    }
}
