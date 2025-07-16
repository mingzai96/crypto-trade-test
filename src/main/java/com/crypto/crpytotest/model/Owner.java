package com.crypto.crpytotest.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String username;
    
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "owner")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "owner")
    private List<Transaction> transactions;


}
