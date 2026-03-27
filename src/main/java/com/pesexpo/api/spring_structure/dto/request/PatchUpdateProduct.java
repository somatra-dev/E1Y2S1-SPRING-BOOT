package com.pesexpo.api.spring_structure.dto.request;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PatchUpdateProduct(

        String name,

        BigDecimal price,

        Integer qty,
        String description,
        Boolean isAvailable

) {
}
