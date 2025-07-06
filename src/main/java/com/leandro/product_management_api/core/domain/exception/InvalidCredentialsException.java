package com.leandro.product_management_api.core.domain.exception;

public class InvalidCredentialsException extends RuntimeException{
    private static final String default_message = "Credentials invalid";

    public InvalidCredentialsException(){
        super(default_message);
    }

    public InvalidCredentialsException(String message){
        super(message);
    }
}
