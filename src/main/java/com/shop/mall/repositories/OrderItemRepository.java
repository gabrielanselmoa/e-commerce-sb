package com.shop.mall.repositories;

import com.shop.mall.entities.Order;
import com.shop.mall.entities.OrderItem;
import com.shop.mall.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
