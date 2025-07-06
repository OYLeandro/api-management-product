package com.leandro.product_management_api.core.domain.exception;

public class UserNotFoundException extends RuntimeException{
    private static final String default_message = "User not found";

    public UserNotFoundException(){
        super(default_message);
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
