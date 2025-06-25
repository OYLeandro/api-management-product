package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.domain.entity.UserEntity;
import com.leandro.product_management_api.dtos.requestdtos.UserRequestDto;
import com.leandro.product_management_api.dtos.responsedtos.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserRequestDto requestDto);

    UserResponseDto toDto(UserEntity user);
}
