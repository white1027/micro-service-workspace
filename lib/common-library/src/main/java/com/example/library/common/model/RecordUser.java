package com.example.library.common.model;


import java.io.Serializable;

public record RecordUser(String id, String name, Integer age) implements Serializable {
}

