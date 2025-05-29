package com.treinoSecurity.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.treinoSecurity.Models.Product;
import com.treinoSecurity.Repositories.ProductRepository;

@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
