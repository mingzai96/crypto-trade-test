package com.crypto.crpytotest.entities;

import jakarta.persistence.*;

@Entity
public class Ticker {
    @Id
    private String symbol;
    private double bidPrice;
    private double bidQty;
    private double askPrice;
    private double askQty;

    // --- Getters ---

    public String getSymbol() {
        return symbol;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public double getBidQty() {
        return bidQty;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public double getAskQty() {
        return askQty;
    }

    // --- Setters ---

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setBidQty(double bidQty) {
        this.bidQty = bidQty;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public void setAskQty(double askQty) {
        this.askQty = askQty;
    }
}
