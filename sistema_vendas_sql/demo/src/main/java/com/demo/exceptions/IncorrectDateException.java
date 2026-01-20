package com.demo.exceptions;

public class IncorrectDateException extends RuntimeException{
    public IncorrectDateException(String message){
        super(message);
    }
}
