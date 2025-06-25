package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.domain.entity.ProductEntity;
import com.leandro.product_management_api.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import com.leandro.product_management_api.dtos.updatedto.ProductUpdateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toDto(ProductEntity entity);

    ProductEntity toEntity(ProductRequestDTO requestDTO);


    List<ProductResponseDTO> toDtoList (List<ProductEntity> entity);
}
