package com.leandro.product_management_api.core.domain.repository;


import com.leandro.product_management_api.core.domain.pagination.PageRequest;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.core.domain.pagination.Page;

import java.util.Optional;

public interface ProductRepository {
    Page<Product> findAll(PageRequest request);
    Product save(Product product);
    boolean existsById(Long id);
    Optional<Product> findById(Long id);
    void deleteById(Long Id);
    void delete(Product product);
}
