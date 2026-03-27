package com.pesexpo.api.spring_structure.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String message,
        Integer code,
        Object errorsDetails

) {
}
