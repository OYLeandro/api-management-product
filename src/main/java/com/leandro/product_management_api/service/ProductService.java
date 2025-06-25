package com.leandro.product_management_api.service;


import com.leandro.product_management_api.domain.entity.ProductEntity;
import com.leandro.product_management_api.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import com.leandro.product_management_api.dtos.updatedto.ProductUpdateDTO;
import com.leandro.product_management_api.mapper.ProductMapper;
import com.leandro.product_management_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponseDTO registerProduct(ProductRequestDTO requestDTO){
        ProductEntity entity = mapper.toEntity(requestDTO);
        ProductEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public ProductResponseDTO getProduct(Long id){
        if(id == null || id < 0){throw new IllegalArgumentException();}
        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID "+ id));
        return mapper.toDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> listAll(){
        List<ProductEntity> list = repository.findAll();
        return list.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Page<ProductResponseDTO> listWithPage(String category, Pageable pageable){
        Page<ProductEntity> list;
        if(category == null || category.isBlank()){
            list = repository.findAll(pageable);
        }else {
            list = repository.findByCategory(category, pageable);
        }
        return list.map(mapper::toDto);
    }

    public ProductResponseDTO updateProduct(Long id, ProductUpdateDTO dto){
        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID "+ id));

        if(dto.name() != null){
            if (dto.name().isBlank()){
                throw new IllegalArgumentException("Name cannot be empty");
            }
            String newName = dto.name().trim();
            product.setName(newName);
        }

        if(dto.price() != null){
            if(dto.price().compareTo(BigDecimal.ZERO) < 0){
                throw new IllegalArgumentException("Price cannot be with negative");
            }
            product.setPrice(dto.price());
        }

        if (dto.Stock() != null){
            if (dto.Stock() < 0){
                throw new IllegalArgumentException("The stock cannot have a negative balance");
            }
            product.setStock(dto.Stock());
        }
        return mapper.toDto(product);
    }

    public void delete(Long id){
        if(id == null || id < 0){throw new IllegalArgumentException("Id invalid");}
        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID "+id));
        repository.delete(product);
    }

}
