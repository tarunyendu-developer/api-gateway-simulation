package com.gateway.service;

import com.gateway.entity.Order;
import com.gateway.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //  Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //  Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    //  Create order
    public Order createOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    //  Delete order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}