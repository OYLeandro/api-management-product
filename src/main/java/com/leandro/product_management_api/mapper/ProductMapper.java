package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.domain.entity.ProductEntity;
import com.leandro.product_management_api.dtos.createdtos.ProductCreateDTO;
import com.leandro.product_management_api.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductCreateDTO dto);

    ProductResponseDTO toDto(ProductEntity entity);

    ProductEntity toEntity(ProductRequestDTO dto);

    List<ProductResponseDTO> toDtoList (List<ProductEntity> entity);
}
