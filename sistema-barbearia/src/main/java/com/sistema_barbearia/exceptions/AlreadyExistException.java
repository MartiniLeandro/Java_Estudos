package com.sistema_barbearia.exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String msg){
        super(msg);
    }
}
