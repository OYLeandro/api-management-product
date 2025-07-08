package com.leandro.product_management_api.infra.mapper;

import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.infra.entity.ProductEntity;

public class ProductMapper {

    public static Product toDomain(ProductEntity entity){
        return new Product(entity.getId(), entity.getName(), entity.getPrice(), entity.getStock(), entity.getCategory());
    }

    public static ProductEntity toEntity(Product product){
        return new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getCategory());
    }
}
