package com.leandro.product_management_api.domain.dtos.requestdtos;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price,
        Integer stock
) {
}
