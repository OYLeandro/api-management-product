package com.leandro.product_management_api.dtos.updatedto;


import java.math.BigDecimal;

public record ProductUpdateDTO(
        String name,
        BigDecimal price,
        Integer Stock,
        String category
) {
}
