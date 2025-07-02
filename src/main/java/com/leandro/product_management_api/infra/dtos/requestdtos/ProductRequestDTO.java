package com.leandro.product_management_api.infra.dtos.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "Name cannot be empty")
        String name,
        @NotNull(message = "Price cannot be null")
        BigDecimal price,
        @NotBlank(message = "Stock cannot be empty")
        Integer stock
) {
}
