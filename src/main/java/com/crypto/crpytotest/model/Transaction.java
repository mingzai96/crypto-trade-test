package com.crypto.crpytotest.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String type;
    private double amount;
    private double price;

    private LocalDateTime createdDateTime;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
