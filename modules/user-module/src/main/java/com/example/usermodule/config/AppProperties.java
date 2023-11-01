package com.example.usermodule.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
@Data
public class AppProperties {
    // 變數名要跟設定檔的一致
    private SnowflakeProperties snowflake;
}
