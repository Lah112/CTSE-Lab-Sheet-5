package com.example.paymentservice.model;

public class payment {
    private int id;
    private int orderId;
    private double amount;
    private String method;
    private String status;

    public payment() {}

    public payment(int id, int orderId, double amount, String method, String status) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    // Getters
    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setMethod(String method) { this.method = method; }
    public void setStatus(String status) { this.status = status; }
}