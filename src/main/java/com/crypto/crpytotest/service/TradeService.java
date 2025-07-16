package com.crypto.crpytotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class TradeService {
    @Autowired
    private WalletRepository walletRepository;

    public Boolean buyCrypto(@RequestParam Long ownerId,
                            @RequestParam String symbol,
                            @RequestParam double amount
    ) {
        return true;
    }

    public Boolean sellCrypto(@RequestParam Long ownerId,
                            @RequestParam String symbol,
                            @RequestParam double amount
    ) {
        return true;
    }

    public List<Ticker> getAllTickers(){
        return null;
    }
}
