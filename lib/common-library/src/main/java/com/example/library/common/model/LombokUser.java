package com.example.library.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LombokUser implements Serializable {
    String name;
    Integer age;
}

