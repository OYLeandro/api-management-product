package com.leandro.product_management_api.mapper;

import com.leandro.product_management_api.domain.entity.UserEntity;
import com.leandro.product_management_api.dtos.responsedtos.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserResponseDto userResponseDto);

    UserResponseDto toDto(UserEntity user);
}
