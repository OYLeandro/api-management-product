package com.leandro.product_management_api.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;


    public ProductEntity(String name, BigDecimal price, Integer stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void updateProduct(String name, BigDecimal price, Integer stock){
        if(name != null && !name.isBlank()){this.name = name;}
        if(price != null && price.compareTo(BigDecimal.ZERO) >= 0){this.price = price;}
        if(stock != null && stock >= 0){this.stock = stock;}
    }
}
