package com.shop.mall.services;

import com.shop.mall.entities.Product;
import com.shop.mall.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> productOpt = repository.findById(id);
        return productOpt.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
