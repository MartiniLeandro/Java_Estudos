package com.SistemaBilioteca_springboot.errors;

public class ViolationContractException extends RuntimeException{
    public ViolationContractException(String msg){
        super(msg);
    }
}
