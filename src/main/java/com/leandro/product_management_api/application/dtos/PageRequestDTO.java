package com.leandro.product_management_api.application.dtos;

public record PageRequestDTO(
        int page,
        int size
) {
}
