package com.leandro.product_management_api.infra.repository;

import com.leandro.product_management_api.infra.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long>{

   Page<ProductEntity> findByCategory(String category, Pageable pageable);
}
