package com.leandro.product_management_api.core.domain.exception;

public class EmailAlreadyRegisteredException extends RuntimeException{
    private static final String default_message = "Email already registered";

    public EmailAlreadyRegisteredException(){
        super(default_message);
    }

    public EmailAlreadyRegisteredException(String message){
        super(message);
    }
}
