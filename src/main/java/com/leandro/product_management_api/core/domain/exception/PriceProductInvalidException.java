package com.leandro.product_management_api.core.domain.exception;

public class PriceProductInvalidException extends RuntimeException{
    private static final String default_message = "Product with invalid price ";

    public PriceProductInvalidException(){
        super(default_message);
    }

    public PriceProductInvalidException(String message){
        super(message);
    }
}
