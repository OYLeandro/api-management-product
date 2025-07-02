package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.entity.UserEntity;
import com.leandro.product_management_api.dtos.requestdtos.AuthRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.AuthResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    UserEntity toEntity(AuthRequestDTO requestDTO);

    AuthResponseDTO toDto(UserEntity entity);

}
