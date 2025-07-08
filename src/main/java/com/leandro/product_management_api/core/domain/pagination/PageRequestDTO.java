package com.leandro.product_management_api.core.domain.pagination;

public record PageRequestDTO(
        int page,
        int size
) {
}
