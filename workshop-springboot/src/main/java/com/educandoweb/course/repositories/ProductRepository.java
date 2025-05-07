package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
