package com.example.library.common.model.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
