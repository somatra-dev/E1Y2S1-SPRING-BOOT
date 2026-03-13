package com.pesexpo.api.spring_structure.dto.request;

import java.math.BigDecimal;

public record UpdateProduct(
        Integer code,
        BigDecimal price,
        String name
) {
}
