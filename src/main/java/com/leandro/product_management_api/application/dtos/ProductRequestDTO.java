package com.leandro.product_management_api.application.dtos;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price,
        Integer stock,
        String category
) {
}
