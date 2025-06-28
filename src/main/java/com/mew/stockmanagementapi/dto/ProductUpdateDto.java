package com.mew.stockmanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * DTO for {@link com.mew.stockmanagementapi.model.Product}
 */
public record ProductUpdateDto(@NotNull @PositiveOrZero Long sku, @NotBlank String name, @PositiveOrZero int price,
                               @PositiveOrZero int weight,
                               @NotBlank @URL String imageUrl) implements Serializable {
}