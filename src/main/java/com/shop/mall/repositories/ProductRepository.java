package com.shop.mall.repositories;

import com.shop.mall.entities.Product;
import com.shop.mall.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
