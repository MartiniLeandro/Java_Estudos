package com.SistemaBilioteca_springboot.errors;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String msg){
        super(msg);
    }
}
