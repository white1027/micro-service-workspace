package com.example.library.common.model.user;


import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(title = "使用 Record 產生的 User")
public record UserResponse(
        @Schema(title = "Id", description = "雪花算法取得")
        String id,
        @Schema(title = "姓名", description = "姓名")
        String name,
        @Schema(title = "年齡", description = "")
        Integer age)
        implements Serializable {
}

