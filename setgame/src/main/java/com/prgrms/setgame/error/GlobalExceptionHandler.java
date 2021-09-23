package com.prgrms.setgame.error;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

@Slf4j
public class GlobalExceptionHandler {
    private ResponseEntity newResponse(Throwable throwable, HttpStatus status) {
        return new ResponseEntity<>(throwable.getMessage(), status);
    }


    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleInternalServerError(Throwable throwable) {
        log.error("Internal Server Error: {}", throwable.getMessage());
        return newResponse(throwable, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //400 - Bad Request
    @ExceptionHandler({IllegalArgumentException.class,
            IllegalStateException.class,
            TypeMismatchException.class,
            MissingServletRequestParameterException.class,})
    public ResponseEntity handleBadRequestException(Throwable throwable) {
        log.error("Bad Request: {}", throwable.getMessage());
        return newResponse(throwable, HttpStatus.BAD_REQUEST);
    }


    //404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(Throwable throwable) {
        log.error("Not found: {}", throwable.getMessage());
        return newResponse(throwable, HttpStatus.NOT_FOUND);
    }

}
