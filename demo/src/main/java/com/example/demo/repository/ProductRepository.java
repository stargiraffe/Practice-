package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    
    List<Product> findByNameLike(String productName);
    
    List<Product> findByNameLike(String productName, Sort sort);

}   