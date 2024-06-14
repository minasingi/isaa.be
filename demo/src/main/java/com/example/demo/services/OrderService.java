package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Narudžbina sa ID " + id + " nije pronađena."));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void updateOrder(Order order) {
        Order existingOrder = getOrderById(order.getId());
        existingOrder.setTotalPrice(order.getTotalPrice());
        existingOrder.setProducts(order.getProducts());
        existingOrder.setUser(order.getUser());
        orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        getOrderById(id);
        orderRepository.deleteById(id);
    }
}
