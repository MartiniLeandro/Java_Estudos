package com.SistemaBilioteca_springboot.infra;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SistemaBilioteca_springboot.errors.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ErrorAPI> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        ErrorAPI error = new ErrorAPI(HttpStatus.NOT_FOUND.value(), "Not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ErrorAPI> ConstraintViolation(ConstraintViolationException e, HttpServletRequest request){
        ErrorAPI error = new ErrorAPI(HttpStatus.BAD_REQUEST.value(), "Violation Contract", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
