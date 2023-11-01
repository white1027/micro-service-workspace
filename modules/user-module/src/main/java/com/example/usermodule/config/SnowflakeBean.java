package com.example.usermodule.config;

import com.example.library.common.utils.SnowflakeDistributeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeBean {

    @Bean
    SnowflakeDistributeId snowflakeDistributeId(AppProperties appProperties) {
        return new SnowflakeDistributeId(appProperties.getSnowflake().getWorkerId(), appProperties.getSnowflake().getDatacenterId());
    }
}
