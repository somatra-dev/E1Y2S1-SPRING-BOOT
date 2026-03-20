package com.pesexpo.api.spring_structure.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String code,
        String name,
        BigDecimal price,
        Integer qty,
        String description,
        String categoryId,
        Boolean isAvailable
) {
}
