package com.leandro.product_management_api.core.domain.pagination;

import java.util.List;

public record PageResult<T>(
        List<T> items,
        int currentPage,
        int totalPage,
        long totalItems
) { }
