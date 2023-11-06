package com.example.library.common.model.user.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Schema(title = "Database User", description = "跟DB同樣結構的類別")
public class User implements Serializable {
    @Schema(title = "Id", description = "雪花算法取得")
    private Long id;
    @Schema(title = "姓名", description = "姓名")
    private String name;
    @Schema(title = "年齡", description = "")
    private Integer age;
}
