package com.leandro.product_management_api.core.domain.exception;

public class ListPageInvalidException extends RuntimeException{
    private static final String default_message = "List Page invalid";

    public ListPageInvalidException(){
        super(default_message);
    }

    public ListPageInvalidException(String message){
        super(message);
    }
}
