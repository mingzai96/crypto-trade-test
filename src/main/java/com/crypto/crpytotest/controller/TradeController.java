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
    public Boolean buyCrypto(@RequestParam Long ownerId,
                            @RequestParam String symbol,
                            @RequestParam double amount
    ) {
        return tradeService.buyCrypto(ownerId, symbol, amount);
    }
    
    // sell
    @PostMapping("/sell")
    public Boolean sellCrypto(@RequestParam Long ownerId,
                            @RequestParam String symbol,
                            @RequestParam double amount
    ) {
        return tradeService.sellCrypto(ownerId, symbol, amount);
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
