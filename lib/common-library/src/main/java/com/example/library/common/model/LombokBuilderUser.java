package com.example.library.common.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class LombokBuilderUser implements Serializable {
    String name;
    Integer age;
}
