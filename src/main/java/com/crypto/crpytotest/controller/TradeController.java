package com.crypto.crpytotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crypto.crpytotest.service.TradeService;

@RestController
@RequestMapping("/api/trade")
public class TradeController {
    
    @Autowired
    private TradeService tradeService;

    
}
