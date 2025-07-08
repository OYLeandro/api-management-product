package com.leandro.product_management_api.application.service;

import com.leandro.product_management_api.application.dtos.*;
import com.leandro.product_management_api.core.domain.entity.Product;
import com.leandro.product_management_api.core.domain.exception.*;
import com.leandro.product_management_api.core.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService( ProductRepository repository ){
        this.repository = repository;
    }

    public ProductResponseDTO getProduct (Long id){
        Product product = repository.findById(id)
                .orElseThrow(() -> new  ProductNotFoundException("Product not found with id: "+id));

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }

    public ProductResponseDTO register (ProductRequestDTO dto){
        String name = dto.name();
        BigDecimal price = dto.price();
        Integer stock = dto.stock();
        String category = dto.category();

        if (name == null || name.isBlank()){
            throw new NameProductInvalidException();
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0){
            throw new PriceProductInvalidException();
        }

        if (stock == null || stock < 0){
            throw new StockProductInvalidException();
        }

        if (category == null || category.isBlank()){
            throw new CategoryProductInvalidException();
        }

        Product newProduct = new Product(name.trim(), price, stock, category.trim());
        repository.save(newProduct);
        return new ProductResponseDTO(
                newProduct.getId(),
                newProduct.getName(),
                newProduct.getPrice(),
                newProduct.getStock(), newProduct.getCategory());
    }

    public PageResponseDTO<ProductResponseDTO> listWithPage (PageRequestDTO dto){
        if (dto == null || dto.size() <= 0 || dto.page() < 0 ){
            throw new ListPageInvalidException("Parameters cannot be null and negative ");
        }

        PageResultDTO<Product> result = repository.findAllPaginated(dto.page(), dto.size());

        List<ProductResponseDTO> responseDTOList = result.items().stream()
                .map(this::toResponseDTO)
                .toList();

        return new PageResponseDTO<>(
                responseDTOList,
                result.currentPage(),
                result.totalPage(),
                result.totalItems()
        );
    }

    public PageResponseDTO<ProductResponseDTO> listByCategory (String category, PageRequestDTO dto){
        if (category == null || category.isBlank()){
            throw new CategoryProductInvalidException();
        }

        if (dto == null || dto.size() <= 0 || dto.page() < 0 ){
            throw new ListPageInvalidException("Parameters cannot be null and negative ");
        }

        PageResultDTO<Product> result = repository.findByCategory(category, dto.page(), dto.size());

        List<ProductResponseDTO> responseDTOList = result.items().stream()
                .map(this::toResponseDTO)
                .toList();

        return new PageResponseDTO<>(
                responseDTOList,
                result.currentPage(),
                result.totalPage(),
                result.totalItems()
        );
    }

    private ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }
}
