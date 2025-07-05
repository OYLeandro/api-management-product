package com.leandro.product_management_api.core.domain.exception;

public class StockProductInvalidException extends RuntimeException{
    private static final String default_message = "Stock invalid";

    public StockProductInvalidException(){
        super(default_message);
    }

    public StockProductInvalidException(String message){
        super(message);
    }
}
