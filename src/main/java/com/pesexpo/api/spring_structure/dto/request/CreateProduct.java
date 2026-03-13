package com.pesexpo.api.spring_structure.dto.request;

import java.math.BigDecimal;

public record CreateProduct(
        Integer code,
        String name,
        BigDecimal price

) {
}
