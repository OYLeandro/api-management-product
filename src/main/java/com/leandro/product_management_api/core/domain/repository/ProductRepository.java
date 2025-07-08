package com.leandro.product_management_api.core.domain.repository;


import com.leandro.product_management_api.application.dtos.PageRequestDTO;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.application.dtos.PageResultDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    PageResultDTO<Product> findByCategory(String category, int page, int size);
    PageResultDTO<Product> findAllPaginated(int page, int size);
    Product save(Product product);
    boolean existsById(Long id);
    Optional<Product> findById(Long id);
    void deleteById(Long id);
}
