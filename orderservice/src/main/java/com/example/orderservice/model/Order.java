package com.example.orderservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Optional: ignores nulls in JSON responses
public class Order {

    private Integer id;           // ID assigned by controller
    private String item;          // Name of the item
    private Integer quantity;     // Quantity ordered
    private String customerId;    // Customer who placed the order
    private String status;        // Status: PENDING, COMPLETED, etc.

    // Default constructor (required for JSON deserialization)
    public Order() {}

    // Parameterized constructor (optional, can be used internally)
    public Order(Integer id, String item, Integer quantity, String customerId, String status) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.customerId = customerId;
        this.status = status;
    }

    // ===== Getters =====
    public Integer getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getStatus() {
        return status;
    }

    // ===== Setters =====
    public void setId(Integer id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ===== Optional: toString for debugging =====
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", customerId='" + customerId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}