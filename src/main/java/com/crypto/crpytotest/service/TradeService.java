package com.crypto.crpytotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.repository.TickerRepository;
import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class TradeService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TickerRepository tickerRepository;

    public Boolean buyCrypto(Long ownerId,
                            String symbol,
                            double amount
    ) {
        return true;
    }

    public Boolean sellCrypto(Long ownerId,
                            String symbol,
                            double amount
    ) {
        return true;
    }

    public List<Ticker> getAllTickers(){
        return tickerRepository.findAll();
    }

    
    public Ticker getTickerBySymbol(String symbol){
        return tickerRepository.findById(symbol).orElseThrow();
    }
}
