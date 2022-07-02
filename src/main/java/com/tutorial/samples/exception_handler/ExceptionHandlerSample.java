package com.tutorial.samples.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerSample {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception) {
        return new ResponseEntity<>("An error has occurred!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
