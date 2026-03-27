package com.pesexpo.api.spring_structure.dto.request;

import java.math.BigDecimal;

public record UpdateProduct(
        BigDecimal price,
        String name,
        Integer qty
) {
}
