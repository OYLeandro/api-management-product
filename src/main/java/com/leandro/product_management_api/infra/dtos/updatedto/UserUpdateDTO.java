package com.leandro.product_management_api.dtos.updatedto;

import com.leandro.product_management_api.core.domain.role.UserRole;

public record UserUpdateDTO(
        String email,
        String password,
        UserRole role
) {
}
