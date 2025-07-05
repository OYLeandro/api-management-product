package com.leandro.product_management_api.infra.dtos.updatedto;


import java.math.BigDecimal;

public record ProductUpdateDTO(
        String name,
        BigDecimal price,
        Integer Stock,
        String category
) {
}
