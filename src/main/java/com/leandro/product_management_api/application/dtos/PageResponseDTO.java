package com.leandro.product_management_api.application.dtos;

import java.util.List;

public record PageResponseDTO<T>(
        List<T> items,
        int currentPage,
        int totalPages,
        long totalItems
) {
}
