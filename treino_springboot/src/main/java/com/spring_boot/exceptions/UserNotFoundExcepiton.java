package com.spring_boot.exceptions;

public class UserNotFoundExcepiton extends RuntimeException{
    public UserNotFoundExcepiton(String msg){
        super(msg);
    }
}
