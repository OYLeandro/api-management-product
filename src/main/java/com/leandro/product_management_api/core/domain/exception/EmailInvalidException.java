package com.leandro.product_management_api.core.domain.exception;

public class EmailInvalidException extends RuntimeException{
    private static final String default_message = "Email invalid ";

    public EmailInvalidException(){
        super(default_message);
    }

    public EmailInvalidException(String message){
        super(message);
    }
}
