package com.leandro.product_management_api.core.domain.exception;

public class RoleInvalidException extends RuntimeException{
    private static final String default_message = "Role invalid";

    public RoleInvalidException(){
        super(default_message);
    }

    public RoleInvalidException(String message){
        super(message);
    }
}
