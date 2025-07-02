package com.leandro.product_management_api.infra.mapper;

import com.leandro.product_management_api.infra.entity.ProductEntity;
import com.leandro.product_management_api.infra.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.infra.dtos.responsedtos.ProductResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toDto(ProductEntity entity);

    ProductEntity toEntity(ProductRequestDTO requestDTO);


    List<ProductResponseDTO> toDtoList (List<ProductEntity> entity);
}
