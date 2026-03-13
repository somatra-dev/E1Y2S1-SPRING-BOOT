package com.pesexpo.api.spring_structure.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
        Integer code,
        String name,
        BigDecimal price
) {
}
