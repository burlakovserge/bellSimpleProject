package ru.bellintegrator.practice.utils;

import org.springframework.stereotype.Component;


public class ResponseVoidMethod {
    private String result;

    public ResponseVoidMethod(String result) {
        this.result = result;
    }

    public ResponseVoidMethod() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
