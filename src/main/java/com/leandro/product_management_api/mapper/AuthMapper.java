package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.domain.entity.UserEntity;
import com.leandro.product_management_api.dtos.requestdtos.AuthRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.AuthResponseDTO;
import com.leandro.product_management_api.dtos.responsedtos.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    UserEntity toEntity(AuthRequestDTO requestDTO);

    AuthResponseDTO toDto(UserEntity entity);

}
