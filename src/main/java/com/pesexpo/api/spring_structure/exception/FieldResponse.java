package com.pesexpo.api.spring_structure.exception;

import lombok.Builder;

@Builder
public record FieldResponse(
        String field,
        String message
) {
}