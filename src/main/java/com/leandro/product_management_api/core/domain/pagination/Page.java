package com.leandro.product_management_api.core.domain.pagination;

import java.util.List;

public record Page<T>(
        List<T> content,
        int pageNamber,
        int pageSize,
        long totalElements
) { }
