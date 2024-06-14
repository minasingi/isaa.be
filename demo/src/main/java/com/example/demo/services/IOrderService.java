package com.example.demo.services;

import com.example.demo.entities.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(Long userId);
    void updateOrder(Order order);
    void deleteOrder(Long id);
}
