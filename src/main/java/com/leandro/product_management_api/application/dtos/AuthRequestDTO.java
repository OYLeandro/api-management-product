package com.leandro.product_management_api.application.dtos;

public record AuthRequestDTO(
        String email,
        String password
) {
}
