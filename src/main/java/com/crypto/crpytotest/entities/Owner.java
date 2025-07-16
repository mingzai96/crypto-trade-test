package com.crypto.crpytotest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(mappedBy = "owner")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "owner")
    private List<Transaction> transactions;


}
