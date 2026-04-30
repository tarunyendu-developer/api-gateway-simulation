package com.gateway.controller;

import com.gateway.dto.OrderDTO;
import com.gateway.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //  GET all orders
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    //  GET order by ID
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    //  POST create order
    @PostMapping
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    //  DELETE order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}