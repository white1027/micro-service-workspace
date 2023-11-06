package com.example.library.common.model.user;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(title = "User 查詢用參數")
public record UserSearchParam(
        @Schema(title = "姓名", description = "模糊查詢", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String name,
        @Schema(title = "年齡", description = "精準查詢", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        Integer age
) implements Serializable {
}