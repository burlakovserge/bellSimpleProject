package ru.bellintegrator.practice.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.utils.ResponseVoidMethod;
import ru.bellintegrator.practice.utils.SuccessResponse;

import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class CustomResponse implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getContainingClass().isAnnotationPresent(RestControllerAdvice.class)) {
            System.out.println("this is exception");
            return o;
        }

        if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
            if ((o instanceof Dto) || (o instanceof  Collection)) {
                System.out.println("This is dto or collection");
                return new SuccessResponse(o);
            }
        }

        System.out.println("this is not list and not exception");
        return new SuccessResponse(new ResponseVoidMethod("success"));
    }
}

