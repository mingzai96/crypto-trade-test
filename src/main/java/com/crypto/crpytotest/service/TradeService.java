package com.crypto.crpytotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class TradeService {
    @Autowired
    private WalletRepository tradeRepository;
}
