package com.shop.mall.repositories;

import com.shop.mall.entities.Payment;
import com.shop.mall.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
