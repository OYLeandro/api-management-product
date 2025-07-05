package com.leandro.product_management_api.core.domain.repository;


import com.leandro.product_management_api.core.domain.pagination.PageRequest;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.core.domain.pagination.Page;

public interface ProductRepository {
    Page<Product> findAll(PageRequest request);
}
