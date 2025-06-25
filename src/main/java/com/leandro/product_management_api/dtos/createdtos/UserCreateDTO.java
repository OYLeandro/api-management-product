package com.leandro.product_management_api.dtos.createdtos;

import com.leandro.product_management_api.role.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(
        @NotBlank(message = "Name cannot be empty")
        String email,
        @NotBlank(message = "Password cannot be empty")
        String password,
        @NotNull(message = "Role cannot be null")
        UserRole role
) {
}
