package com.shop.mall.services.exceptions;

public class ResouceNotFoundException extends RuntimeException{

    public ResouceNotFoundException(Object id){
        super("Resource not found. Id: " + id);
    }
}
