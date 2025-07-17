package com.crypto.crpytotest.dto;

public interface ITicker {
    String getSymbol();
    double getAskPrice();
    double getAskQty();
    double getBidPrice();
    double getBidQty();

    void setSymbol(String symbol);
    void setBidPrice(double bidPrice);
    void setBidQty(double bidQty);
    void setAskPrice(double askPrice);
    void setAskQty(double askQty);
}
