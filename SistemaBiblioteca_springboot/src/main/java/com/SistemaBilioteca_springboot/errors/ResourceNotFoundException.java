package com.SistemaBilioteca_springboot.errors;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super("Resource not found. ID: " + id);
    }
}
