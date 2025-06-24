package com.leandro.product_management_api.dtos.createdtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDTO(
        @NotBlank(message = "Name cannot be empty")
        String name,
        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.0")
        BigDecimal price,
        @NotNull(message = "Stock cannot be null")
        @Min(value = 1)
        Integer stock,
        @NotBlank(message = "Category cannot be empty")
        String category) {
}
