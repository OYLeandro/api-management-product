package com.leandro.product_management_api.infra.implementation;

import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.application.dtos.PageResultDTO;
import com.leandro.product_management_api.core.domain.repository.ProductRepository;
import com.leandro.product_management_api.infra.entity.ProductEntity;
import com.leandro.product_management_api.infra.mapper.ProductMapper;
import com.leandro.product_management_api.infra.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public PageResultDTO<Product> findByCategory(String category, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);

        Page <ProductEntity> pageResult = jpaProductRepository.findByCategory(category, pageable);

        List<Product> products = pageResult.getContent().stream()
                .map(ProductMapper::toDomain)
                .toList();

        return new PageResultDTO<>(
                products,
                pageResult.getNumber(),
                pageResult.getTotalPages(),
                pageResult.getTotalElements()
        );
    }

    @Override
    public PageResultDTO<Product> findAllPaginated(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page <ProductEntity> pageResult = jpaProductRepository.findAll(pageable);

        List<Product> products = pageResult.getContent().stream()
                .map(ProductMapper::toDomain)
                .toList();

        return new PageResultDTO<>(
                products,
                pageResult.getNumber(),
                pageResult.getTotalPages(),
                pageResult.getTotalElements()
        );
    }

    @Override
    public Product save(Product product) {
        jpaProductRepository.save(ProductMapper.toEntity(product));
        return product;
    }

    @Override
    public boolean existsById(Long id) {
        return jpaProductRepository.existsById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(ProductMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }
}
