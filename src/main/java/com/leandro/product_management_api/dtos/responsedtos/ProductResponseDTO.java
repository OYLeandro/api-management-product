package com.leandro.product_management_api.dtos.responsedtos;

import com.leandro.product_management_api.domain.entity.ProductEntity;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, BigDecimal price, Integer stock, String category) {
    public ProductResponseDTO(ProductEntity entity){
        this(entity.getId(), entity.getName(), entity.getPrice(), entity.getStock(), entity.getCategory());
    }
}
