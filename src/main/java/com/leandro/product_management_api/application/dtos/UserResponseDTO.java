package com.leandro.product_management_api.application.dtos;

import com.leandro.product_management_api.core.domain.role.UserRole;

public record UserResponseDTO(
        Long id,
        String email,
        UserRole role
) {
}
