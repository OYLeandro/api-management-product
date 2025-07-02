package com.leandro.product_management_api.dtos.responsedtos;

import com.leandro.product_management_api.entity.UserEntity;
import com.leandro.product_management_api.core.domain.role.UserRole;

public record UserResponseDto(Long id, String email, String password, UserRole role) {
    public UserResponseDto(UserEntity entity){
        this(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getRole());
    }
}
