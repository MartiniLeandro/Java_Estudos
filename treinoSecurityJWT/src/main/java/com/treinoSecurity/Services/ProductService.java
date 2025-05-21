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

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product){
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());

        return productRepository.save(updatedProduct);
    }
}
