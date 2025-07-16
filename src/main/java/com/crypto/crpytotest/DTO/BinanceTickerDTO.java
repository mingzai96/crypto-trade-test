package com.crypto.crpytotest.DTO;

public class BinanceTickerDTO implements ITicker {
    private String symbol;
    private double bidPrice;
    private double bidQty;
    private double askPrice;
    private double askQty;

    // --- Getters ---

    @Override
    public String getSymbol() {
        return symbol;
    }
    @Override
    public double getAskPrice() {
        return askPrice;
    }
    @Override
    public double getAskQty() {
        return askQty;
    }
    @Override
    public double getBidPrice() {
        return bidPrice;
    }
    @Override
    public double getBidQty() {
        return bidQty;
    }

    // --- Setters ---

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    @Override
    public void setBidQty(double bidQty) {
        this.bidQty = bidQty;
    }

    @Override
    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    @Override
    public void setAskQty(double askQty) {
        this.askQty = askQty;
    }
}
