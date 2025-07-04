package com.leandro.product_management_api.repository;

import com.leandro.product_management_api.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

   Page<ProductEntity> findByCategory(String category, Pageable pageable);
}
