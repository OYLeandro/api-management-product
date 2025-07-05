package com.leandro.product_management_api.application.dtos;

public record UserRequestDTO(
        String email,
        String password,
        String role
) {
}
