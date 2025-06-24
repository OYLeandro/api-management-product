package com.leandro.product_management_api.service;


import com.leandro.product_management_api.domain.entity.ProductEntity;
import com.leandro.product_management_api.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import com.leandro.product_management_api.mapper.ProductMapper;
import com.leandro.product_management_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponseDTO registerProduct(ProductRequestDTO requestDTO){
        ProductEntity newEntity = mapper.toEntity(requestDTO);
        return mapper.toDto(newEntity);
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
            list = repository.findByCategory(category, pageable)
                    .orElseThrow(() -> new IllegalArgumentException("Category not found with name "+category));
        }
        return list.map(mapper::toDto);
    }

    public void delete(Long id){
        if(id == null && id < 0){
                throw new IllegalArgumentException("Id invalid");
        }
        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID "+id));
    }

}
