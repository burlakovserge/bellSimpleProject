package ru.bellintegrator.practice.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorView {
    private String errorCode;
    private String message;

    public ErrorView(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

}
