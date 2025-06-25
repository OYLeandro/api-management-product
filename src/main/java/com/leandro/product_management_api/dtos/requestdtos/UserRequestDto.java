package com.leandro.product_management_api.dtos.requestdtos;

import com.leandro.product_management_api.role.UserRole;

public record UserRequestDto(
        String email,
        String password,
        UserRole role
) {
}
