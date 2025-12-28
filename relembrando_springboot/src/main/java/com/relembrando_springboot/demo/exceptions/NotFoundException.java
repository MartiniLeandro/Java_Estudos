package com.relembrando_springboot.demo.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
