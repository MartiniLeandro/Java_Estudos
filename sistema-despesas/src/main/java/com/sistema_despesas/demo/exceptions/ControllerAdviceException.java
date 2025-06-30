package com.sistema_despesas.demo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFound(NotFoundException e, HttpServletRequest request){
        ErrorResponse erro = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Resource Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> AlreadyExist(AlreadyExistsException e, HttpServletRequest request){
        ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Resource Already Exist", e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(NotPertenceException.class)
    public ResponseEntity<ErrorResponse> NotPertence(NotPertenceException e, HttpServletRequest request){
        ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "This Resource don't pertence to you",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
