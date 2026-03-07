package com.pesexpo.api.structure.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
        Integer code,
        String name,
        BigDecimal price
) {
}
