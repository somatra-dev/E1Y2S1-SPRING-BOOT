package com.pesexpo.api.structure.dto.request;

import java.math.BigDecimal;

public record CreateProduct(
        Integer code,
        String name,
        BigDecimal price

) {
}
