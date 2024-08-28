package com.shop.mall.services;

import com.shop.mall.entities.Category;
import com.shop.mall.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> categoryOpt = repository.findById(id);
        return categoryOpt.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
