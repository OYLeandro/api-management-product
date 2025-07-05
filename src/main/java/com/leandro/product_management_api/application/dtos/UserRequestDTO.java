package com.leandro.product_management_api.application.dtos;

import com.leandro.product_management_api.core.domain.role.UserRole;

public record UserRequestDTO(
        String email,
        String password,
        UserRole role
) {
}
