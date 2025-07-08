package com.leandro.product_management_api.core.domain.pagination;

public record PageRequest(
        int page,
        int size
) {
}
