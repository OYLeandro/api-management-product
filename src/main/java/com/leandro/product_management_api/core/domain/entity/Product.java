package com.leandro.product_management_api.core.domain.entity;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String category;

    public Product(String name, BigDecimal price, Integer stock, String category){

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}
