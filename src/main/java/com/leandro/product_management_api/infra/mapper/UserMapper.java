package com.leandro.product_management_api.infra.mapper;

import com.leandro.product_management_api.infra.entity.UserEntity;
import com.leandro.product_management_api.infra.dtos.requestdtos.UserRequestDto;
import com.leandro.product_management_api.infra.dtos.responsedtos.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserRequestDto requestDto);


    UserResponseDto toDto(UserEntity user);
}
