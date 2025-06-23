package com.leandro.product_management_api.domain.dtos.responsedtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        BigDecimal price,
        Integer stock
) {
}
