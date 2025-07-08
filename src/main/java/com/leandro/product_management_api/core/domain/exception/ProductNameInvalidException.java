package com.leandro.product_management_api.core.domain.exception;

public class ProductNameInvalidException extends RuntimeException{
    private static final String default_message = "Product with invalid name ";

    public ProductNameInvalidException(){
        super(default_message);
    }

    public ProductNameInvalidException(String message){
        super(message);
    }
}
