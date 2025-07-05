package com.leandro.product_management_api.core.domain.exception;

public class CategoryProductInvalidException extends RuntimeException{
    private static final String default_message = "Stock invalid";

    public CategoryProductInvalidException(){
        super(default_message);
    }

    public CategoryProductInvalidException(String message){
        super(message);
    }
}
