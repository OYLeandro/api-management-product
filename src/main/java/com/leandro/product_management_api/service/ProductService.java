package com.leandro.product_management_api.service;


import com.leandro.product_management_api.domain.entity.ProductEntity;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import com.leandro.product_management_api.mapper.ProductMapper;
import com.leandro.product_management_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> listAll(){
        List<ProductEntity> products = repository.findAll();
        return productMapper.toDtoList(products);
    }
}
