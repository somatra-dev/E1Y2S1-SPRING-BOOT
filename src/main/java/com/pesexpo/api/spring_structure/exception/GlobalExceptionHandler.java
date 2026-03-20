package com.pesexpo.api.spring_structure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .code(ex.getStatusCode().value())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }
}
