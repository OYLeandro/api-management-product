package com.leandro.product_management_api.core.domain.entity;

import com.leandro.product_management_api.core.domain.exception.CategoryProductInvalidException;
import com.leandro.product_management_api.core.domain.exception.NameProductInvalidException;
import com.leandro.product_management_api.core.domain.exception.PriceProductInvalidException;
import com.leandro.product_management_api.core.domain.exception.StockProductInvalidException;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String category;

    public Product(String name, BigDecimal price, Integer stock, String category){
        if(name == null || name.isBlank()){throw new NameProductInvalidException();}
        if(price == null || price.compareTo(BigDecimal.ZERO) < 0){throw new PriceProductInvalidException();}
        if(stock == null || stock < 0){throw new StockProductInvalidException();}
        if(category == null || category.isBlank()){throw new CategoryProductInvalidException();}
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}
