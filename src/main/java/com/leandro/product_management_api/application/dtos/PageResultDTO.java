package com.leandro.product_management_api.application.dtos;

import java.util.List;

public record PageResultDTO<T>(
        List<T> items,
        int currentPage,
        int totalPage,
        long totalItems
) { }
