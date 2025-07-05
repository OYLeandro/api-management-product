package com.leandro.product_management_api.core.domain.exception;

public class NameProductInvalidException extends RuntimeException{
    private static final String default_message = "Name invalid";
    public NameProductInvalidException(){
        super(default_message);
    }

    public NameProductInvalidException(String message){
        super(message);
    }
}
