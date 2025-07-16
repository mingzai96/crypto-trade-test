package com.crypto.crpytotest.DTO;

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
