package com.leandro.product_management_api.dtos.requestdtos;

import com.leandro.product_management_api.role.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDto(
        @NotBlank(message = "email cannot be empty")
        String email,
        @NotBlank(message = "password cannot be empty")
        String password,
        @NotNull(message = "role cannot be null")
        UserRole role
) {
}
