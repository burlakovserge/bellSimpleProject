package ru.bellintegrator.practice.utils;

public class ResponseSuccess {
    private Object data;

    public ResponseSuccess(Object data) {
        this.data = data;
    }

    public ResponseSuccess() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

