package com.gateway.service;

import com.gateway.dto.OrderDTO;
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

    //  Entity → DTO
    private OrderDTO mapToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .build();
    }

    //  DTO → Entity
    private Order mapToEntity(OrderDTO dto) {
        return Order.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .product(dto.getProduct())
                .quantity(dto.getQuantity())
                .totalPrice(dto.getTotalPrice())
                .status(dto.getStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //  Get all orders
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    //  Get order by ID
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToDTO(order);
    }

    //  Create order
    public OrderDTO createOrder(OrderDTO dto) {
        Order order = mapToEntity(dto);
        return mapToDTO(orderRepository.save(order));
    }

    //  Delete order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}