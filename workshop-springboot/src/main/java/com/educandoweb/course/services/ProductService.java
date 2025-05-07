package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.course.models.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> Product = productRepository.findById(id);
        return Product.get();
    }

    
}
