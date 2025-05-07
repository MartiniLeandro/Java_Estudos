package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.models.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService ProductService) {
        this.productService = ProductService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> Products = productService.listAll();
        return ResponseEntity.ok().body(Products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product Product = productService.findById(id);
        return ResponseEntity.ok().body(Product);
    }
    
}
