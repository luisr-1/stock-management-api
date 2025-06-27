package com.mew.stockmanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDTO(@NotNull @Positive Long sku,
                         @NotBlank String name,
                         @Positive @NotNull int price,
                         @Positive int dimensionsWidth,
                         @Positive int dimensionsHeight,
                         @Positive int dimensionsDepth,
                         @Positive int weight,
                         @NotBlank String imageUrl) {
}
