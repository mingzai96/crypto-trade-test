package com.crypto.crpytotest.dto;

public class HuobiTickerDTO implements ITicker {
    private String symbol;
    private double bid;
    private double bidQty;
    private double ask;
    private double askQty;

    // --- Getters ---

    @Override
    public String getSymbol() {
        return symbol;
    }
    @Override
    public double getAskPrice() {
        return ask;
    }
    @Override
    public double getAskQty() {
        return askQty;
    }
    @Override
    public double getBidPrice() {
        return bid;
    }
    @Override
    public double getBidQty() {
        return bidQty;
    }

    // --- Setters ---
    public void setAsk(double ask){
        this.ask = ask;
    }

    public void setBid(double bid){
        this.bid = bid;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void setBidPrice(double bidPrice) {
        setBid(bidPrice);
    }

    @Override
    public void setBidQty(double bidQty) {
        this.bidQty = bidQty;
    }

    @Override
    public void setAskPrice(double askPrice) {
        setAsk(askPrice);
    }

    @Override
    public void setAskQty(double askQty) {
        this.askQty = askQty;
    }
}
