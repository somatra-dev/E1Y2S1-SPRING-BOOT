package com.pesexpo.api.spring_structure.dto.request;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProduct(

        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 100)
        String name,

        @Positive
        @Nonnull
        BigDecimal price,

        @Nonnull
        @Positive
        Integer qty,

        @Nonnull
        @Positive
        Integer categoryId,

        @NotBlank
        @Size(max = 255)
        String description


) {
}
