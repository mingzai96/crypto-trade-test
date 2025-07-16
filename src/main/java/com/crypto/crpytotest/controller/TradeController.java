package com.crypto.crpytotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.service.TradeService;


@RestController
@RequestMapping("/api/trade")
public class TradeController {
    
    @Autowired
    private TradeService tradeService;

    // buy
    @PostMapping("/buy")
    public void buyCrypto(@RequestParam Long ownerId,
                            @RequestParam String baseCurrency,
                            @RequestParam String quoteCurrency,
                            @RequestParam double amount
    ) {
        tradeService.buyCrypto(ownerId, baseCurrency, quoteCurrency, amount);
    }
    
    // sell
    @PostMapping("/sell")
    public void sellCrypto(@RequestParam Long ownerId,
                            @RequestParam String baseCurrency,
                            @RequestParam String quoteCurrency,
                            @RequestParam double amount
    ) {
        tradeService.sellCrypto(ownerId, baseCurrency, quoteCurrency, amount);
    }

    @GetMapping("/tickers")
    public List<Ticker> getAllTickers(){
        return tradeService.getAllTickers();
    }
    
    @GetMapping("/ticker")
    public Ticker getTickerBySymbol(@RequestParam String symbol){
        return tradeService.getTickerBySymbol(symbol);
    }
}
