package com.demo.exceptions;

public class IncorrectPriceException extends  RuntimeException{
    public IncorrectPriceException(String message){
        super(message);
    }
}
