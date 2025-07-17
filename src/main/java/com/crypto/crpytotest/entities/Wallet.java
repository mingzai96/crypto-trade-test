package com.crypto.crpytotest.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private double balance;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // --- Getters ---
    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedDate(){
        return createdDate;
    }

    public LocalDateTime getUpdatedDate(){
        return updatedDate;
    }

    // --- Setters ---
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    public void setCreatedDate(LocalDateTime createdDate){
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate){
        this.updatedDate = updatedDate;
    }
}
