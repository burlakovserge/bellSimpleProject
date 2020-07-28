package ru.bellintegrator.practice.controllerAdvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.utils.ErrorView;
import ru.bellintegrator.practice.utils.ResponseVoidMethod;
import ru.bellintegrator.practice.utils.ResponseSuccess;

import java.util.Collection;

@RestControllerAdvice
public class CustomResponse implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (!(o instanceof ErrorView)){
            if (o == null){
                return new ResponseSuccess(new ResponseVoidMethod("success"));
            } else return new ResponseSuccess(o);
        }
        return o;
    }
}