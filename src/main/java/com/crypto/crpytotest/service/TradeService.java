package com.crypto.crpytotest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.crpytotest.entities.Owner;
import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.entities.Transaction;
import com.crypto.crpytotest.entities.Wallet;
import com.crypto.crpytotest.repository.OwnerRepository;
import com.crypto.crpytotest.repository.TickerRepository;
import com.crypto.crpytotest.repository.TransactionRepository;
import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class TradeService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TickerRepository tickerRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public void buyCrypto(Long ownerId,
                            String baseCurrency,
                            String quoteCurrency,
                            double amount
    ) {
        String symbol = baseCurrency + quoteCurrency;
        Ticker ticker = tickerRepository.findById(symbol).orElse(null);
        if(ticker == null){
            throw new IllegalArgumentException(symbol + " not available");
        }
        
        if(ticker.getAskQty() < amount){
            throw new IllegalArgumentException("Amount larger than Ask Quantity");
        }
        
        double price = ticker.getAskPrice(); 
        double cost = amount * price;
        
        Wallet quoteWallet = walletRepository.findByOwnerIdAndCurrency(ownerId, quoteCurrency);
        if (quoteWallet == null || quoteWallet.getBalance() < cost){
            throw new IllegalArgumentException("Insufficient balance for " + quoteCurrency);
        }
        
        // If all checking passed
        quoteWallet.setBalance(quoteWallet.getBalance() - cost);
        
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        Wallet baseWallet = walletRepository.findByOwnerIdAndCurrency(ownerId, baseCurrency);
        if(baseWallet == null){
            baseWallet = new Wallet();
            baseWallet.setOwner(owner);
            baseWallet.setCurrency(baseCurrency);
            baseWallet.setBalance(0);
        }
        baseWallet.setBalance(baseWallet.getBalance() + amount);

        Transaction transaction = CreateTransaction(owner, symbol, "BUY", amount, price);

        walletRepository.save(quoteWallet);
        walletRepository.save(baseWallet);
        transactionRepository.save(transaction);
    }

    private Transaction CreateTransaction(Owner owner, String symbol, String type, double amount, double price){
        Transaction transaction = new Transaction();
        transaction.setOwner(owner);
        transaction.setSymbol(symbol);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setPrice(price);
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }

    public void sellCrypto(Long ownerId, String baseCurrency, String quoteCurrency, double amount) {
        String symbol = baseCurrency + quoteCurrency;
        Ticker ticker = tickerRepository.findById(symbol).orElse(null);
        if(ticker == null){
            throw new IllegalArgumentException(symbol + " not available");
        }
        
        if(ticker.getBidQty() < amount){
            throw new IllegalArgumentException("Amount larger than Ask Quantity");
        }
        
        Wallet baseWallet = walletRepository.findByOwnerIdAndCurrency(ownerId, baseCurrency);
        if (baseWallet == null || baseWallet.getBalance() < amount){
            throw new IllegalArgumentException("Insufficient balance for " + baseCurrency);
        }
        
        // If all checking passed
        double price = ticker.getBidPrice();
        baseWallet.setBalance(baseWallet.getBalance() - amount);
        
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        Wallet quoteWallet = walletRepository.findByOwnerIdAndCurrency(ownerId, quoteCurrency);
        if(quoteWallet == null){
            quoteWallet = new Wallet();
            quoteWallet.setOwner(owner);
            quoteWallet.setCurrency(baseCurrency);
            quoteWallet.setBalance(0);
        }
        quoteWallet.setBalance(quoteWallet.getBalance() + (amount * price));

        Transaction transaction = CreateTransaction(owner, symbol, "SELL", amount, price);

        walletRepository.save(quoteWallet);
        walletRepository.save(baseWallet);
        transactionRepository.save(transaction);
    }

    public List<Ticker> getAllTickers(){
        return tickerRepository.findAll();
    }

    
    public Ticker getTickerBySymbol(String symbol){
        return tickerRepository.findById(symbol).orElseThrow();
    }
}
