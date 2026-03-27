package com.pesexpo.api.spring_structure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidation(MethodArgumentNotValidException e) {

        List<FieldResponse> fieldResponses = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            FieldResponse fieldResponse = FieldResponse
                    .builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .build();

            fieldResponses.add(fieldResponse);
        });

        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Request data is invalid")
                .errorsDetails(fieldResponses)
                .build();
    }
}
