package com.crypto.crpytotest.service;

import java.util.List;

import com.crypto.crpytotest.entities.Ticker;

public interface TradeService {
    void buyCrypto(Long ownerId, String baseCurrency, String quoteCurrency, double amount);
    void sellCrypto(Long ownerId, String baseCurrency, String quoteCurrency, double amount);
    List<Ticker> getAllTickers();
    Ticker getTickerBySymbol(String symbol);
}
