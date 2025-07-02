package com.leandro.product_management_api.infra.mapper;

import com.leandro.product_management_api.infra.entity.UserEntity;
import com.leandro.product_management_api.infra.dtos.requestdtos.AuthRequestDTO;
import com.leandro.product_management_api.infra.dtos.responsedtos.AuthResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    UserEntity toEntity(AuthRequestDTO requestDTO);

    AuthResponseDTO toDto(UserEntity entity);

}
