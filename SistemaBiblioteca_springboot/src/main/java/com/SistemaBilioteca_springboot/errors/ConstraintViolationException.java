package com.SistemaBilioteca_springboot.errors;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String msg){
        super(msg);
    }
}
