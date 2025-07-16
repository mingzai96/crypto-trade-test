package com.crypto.crpytotest.entities;

import jakarta.persistence.*;

@Entity
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private double bidPrice;
    private double bidQty;
    private double askPrice;
    private double askQty;
}
