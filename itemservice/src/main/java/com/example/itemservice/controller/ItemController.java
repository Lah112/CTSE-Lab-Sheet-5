package com.example.itemservice.controller;

import com.example.itemservice.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        item.setId(idCounter.getAndIncrement());
        items.add(item);
        return ResponseEntity.status(201).body(item);
    }
}