package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnprocessableException() {
        super();
    }

    public UnprocessableException(String message) {
        super(message);
    }

}