package ru.bellintegrator.practice.controllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import ru.bellintegrator.practice.utils.ErrorView;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorView handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        String code = RandomStringUtils.randomAlphanumeric(4);
        log.warn("Error code " + code + ": " + errors.toString());
        return new ErrorView(code, "Oops, something's wrong. We are already working");
    }

    @ExceptionHandler({NoResultException.class, HttpClientErrorException.BadRequest.class})
    protected ErrorView handleThereIsNoSuchResultException(NoResultException ex) {
        String errorCode = RandomStringUtils.randomAlphanumeric(4);
        log.warn("Error code " + errorCode + ": " + ex.getMessage());
        return new ErrorView(errorCode, "Oops, something's wrong. We are already working");
    }
}