package com.leandro.product_management_api.application.service;

import com.leandro.product_management_api.application.dtos.ProductRequestDTO;
import com.leandro.product_management_api.application.dtos.ProductResponseDTO;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.core.domain.repository.ProductRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService( ProductRepository repository ){
        this.repository = repository;
    }

    public ProductResponseDTO register (ProductRequestDTO dto){
        String name = dto.name();
        BigDecimal price = dto.price();
        Integer stock = dto.stock();
        String category = dto.category();
        if (name == null || name.isBlank()){}
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0){}
        if (stock == null || stock < 0){}
        if (category == null || category.isBlank()){}

        Product newProduct = new Product(name.trim(), price, stock, category.trim());
        repository.save(newProduct);
        return new ProductResponseDTO(
                newProduct.getId(),
                newProduct.getName(),
                newProduct.getPrice(),
                newProduct.getStock(), newProduct.getCategory());
    }
}
