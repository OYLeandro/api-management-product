package com.leandro.product_management_api.core.domain.repository;


import com.leandro.product_management_api.core.domain.pagination.PageRequest;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.core.domain.pagination.Page;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Page<Product> findAllPaginated(PageRequest request);
    Product save(Product product);
    boolean existsById(Long id);
    Optional<Product> findById(Long id);
    void deleteById(Long Id);
    void delete(Product product);
}
