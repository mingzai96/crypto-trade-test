package com.crypto.crpytotest.model;

import jakarta.persistence.*;

@Entity
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String symbol;
    private double bidPrice;
    private double bidQty;
    private double askPrice;
    private double askQty;
}
