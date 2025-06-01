package com.spring_boot.exceptions;

public class ResourceNotFoundExcepiton extends RuntimeException{
    public ResourceNotFoundExcepiton(String msg){
        super(msg);
    }
}
