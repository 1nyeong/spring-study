package com.study.springboot202210h.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomValidException extends RuntimeException {
    @Getter
    private Map<String, String> errorMap;

    public CustomValidException(Map<String, String> errorMap) {
        super("Failed Validation!!!");
        this.errorMap = errorMap;
    }
}