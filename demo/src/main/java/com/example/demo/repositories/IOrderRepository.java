package com.example.demo.repositories;

import com.example.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
