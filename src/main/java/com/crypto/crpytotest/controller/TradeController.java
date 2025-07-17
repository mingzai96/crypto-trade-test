package com.crypto.crpytotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crypto.crpytotest.dto.TradeParamDTO;
import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.service.TradeService;


@RestController
@RequestMapping("/api/trade")
public class TradeController {
    
    @Autowired
    private TradeService tradeService;

    // buy
    @PostMapping("/buy")
    public void buyCrypto(@RequestBody TradeParamDTO param) {
        tradeService.buyCrypto(param.getOwnerId(), param.getBaseCurrency(), param.getQuoteCurrency(), param.getAmount());
    }
    
    // sell
    @PostMapping("/sell")
    public void sellCrypto(@RequestBody TradeParamDTO param) {
        tradeService.sellCrypto(param.getOwnerId(), param.getBaseCurrency(), param.getQuoteCurrency(), param.getAmount());
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
