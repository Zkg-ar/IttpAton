package com.example.demo.error;

import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(final MethodArgumentNotValidException e) {
        return new ErrorResponse("Ошибка валидации:", e.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFound(final UserNotFoundException e) {
        return new ErrorResponse("Ошибка 404:", e.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException e) {
        return new ErrorResponse("Ошибка 500:", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(final Exception e) {
        return new ErrorResponse("Ошибка 500:", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExist(final UserAlreadyExistException e) {
        return new ErrorResponse("Ошибка 409:", e.getMessage());
    }


}

