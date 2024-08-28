package com.shop.mall.services;

import com.shop.mall.entities.Order;
import com.shop.mall.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> orderOpt = repository.findById(id);
        return orderOpt.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
