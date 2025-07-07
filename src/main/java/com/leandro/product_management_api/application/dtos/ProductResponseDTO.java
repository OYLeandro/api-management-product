package com.leandro.product_management_api.application.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        BigDecimal price,
        Integer stock,
        String category
){
}
