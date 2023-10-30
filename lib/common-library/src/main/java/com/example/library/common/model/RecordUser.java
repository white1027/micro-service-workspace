package com.example.library.common.model;


import java.io.Serializable;

public record RecordUser(Long id, String name, Integer age) implements Serializable {
}

