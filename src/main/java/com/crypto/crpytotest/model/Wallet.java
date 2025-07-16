package com.crypto.crpytotest.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String currency;
    private double balance;

    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
