package com.leandro.product_management_api.core.domain.repository;


public interface ProductRepository {
    Page<Product> findAll(PageRequest request);
}
