package com.leandro.product_management_api.dtos.requestdtos;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price,
        Integer stock
) {
}
