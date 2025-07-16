package com.crypto.crpytotest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String type;
    private double amount;
    private double price;

    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // --- Getters ---
    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    // --- Setters ---
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
