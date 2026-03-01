package com.example.paymentservice.controller;

import com.example.paymentservice.model.payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/payments")
public class paymentcontroller {

    private List<payment> payments = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @GetMapping
    public ResponseEntity<List<payment>> getAllPayments() {
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<payment> getPaymentById(@PathVariable int id) {
        return payments.stream()
                .filter(payment -> payment.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/process")
    public ResponseEntity<payment> processPayment(@RequestBody Map<String, Object> paymentRequest) {
        payment payment = new payment();
        payment.setId(idCounter.getAndIncrement());
        payment.setOrderId((Integer) paymentRequest.get("orderId"));
        
        // Handle amount as Double or Integer
        Object amountObj = paymentRequest.get("amount");
        if (amountObj instanceof Integer) {
            payment.setAmount(((Integer) amountObj).doubleValue());
        } else {
            payment.setAmount((Double) amountObj);
        }
        
        payment.setMethod((String) paymentRequest.get("method"));
        payment.setStatus("SUCCESS");
        
        payments.add(payment);
        return ResponseEntity.status(201).body(payment);
    }
}