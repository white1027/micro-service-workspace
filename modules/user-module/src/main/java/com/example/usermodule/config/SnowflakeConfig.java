package com.example.usermodule.config;

import com.example.library.common.utils.SnowflakeDistributeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig {

    @Bean
    SnowflakeDistributeId snowflakeDistributeId() {
        //TODO 加到設定檔
        return new SnowflakeDistributeId(0, 0);
    }

}
