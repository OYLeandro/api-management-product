package com.leandro.product_management_api.core.domain.exception;

public class PriceProductInvalidException extends RuntimeException{
    private static final String default_message = "Price invalid";

    public PriceProductInvalidException(){
        super(default_message);
    }

    public PriceProductInvalidException(String message){
        super(message);
    }
}
