package com.example.spring.model.dto;

public enum Category {
    CONFERENCES("CONFERENCES"),
    SEMINARS("SEMINARS");

    private final String value;

    Category(String value) {
        this.value = value;
    }
}
