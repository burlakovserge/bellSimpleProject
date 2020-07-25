package ru.bellintegrator.practice.utils;

import org.springframework.stereotype.Component;

public class SuccessResponse {
    private Object data;

    public SuccessResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SuccessResponse() {
    }
}
