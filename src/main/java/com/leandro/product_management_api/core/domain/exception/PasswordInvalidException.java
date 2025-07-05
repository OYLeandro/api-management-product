package com.leandro.product_management_api.core.domain.exception;

public class PasswordInvalidException extends RuntimeException{
    private static final String default_message = "Password invalid ";

    public PasswordInvalidException(){
        super(default_message);
    }

    public PasswordInvalidException(String message){
        super(message);
    }
}
