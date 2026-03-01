package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orders = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setId(idCounter.getAndIncrement());
        order.setStatus("PENDING");
        orders.add(order);
        return ResponseEntity.status(201).body(order);
    }
}