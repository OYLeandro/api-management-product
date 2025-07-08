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

    public Product(Long id, String name, BigDecimal price, Integer stock, String category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public void updateName (String name){
        this.name = name;
    }

    public void updatePrice(BigDecimal price){
        this.price = price;
    }

    public void updateStock(Integer stock){
        this.stock = stock;
    }

    public void updateCategory(String category){
        this.category = category;    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }
}
