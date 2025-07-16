package com.crypto.crpytotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.crpytotest.entities.Transaction;
import com.crypto.crpytotest.entities.Wallet;
import com.crypto.crpytotest.repository.TransactionRepository;
import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class OwnerService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private WalletRepository walletRepository;

    OwnerService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Wallet> getWalletByOwnerId(Long ownerId){
        return walletRepository.findByOwnerId(ownerId);
    }

    public List<Transaction> getTransactionsByOwnerId(Long ownerId){
        return transactionRepository.findByOwnerId(ownerId);
    }
}
