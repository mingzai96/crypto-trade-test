package com.crypto.crpytotest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.crpytotest.entities.Owner;
import com.crypto.crpytotest.entities.Transaction;
import com.crypto.crpytotest.entities.Wallet;
import com.crypto.crpytotest.repository.OwnerRepository;
import com.crypto.crpytotest.repository.TransactionRepository;
import com.crypto.crpytotest.repository.WalletRepository;

@Service
public class OwnerServiceImpl implements OwnerService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Wallet> getWalletByOwnerId(Long ownerId){
        return walletRepository.findByOwnerId(ownerId);
    }

    public List<Transaction> getTransactionsByOwnerId(Long ownerId){
        return transactionRepository.findByOwnerId(ownerId);
    }

    public Owner createOwner(String name){
        Owner owner = new Owner();
        owner.setName(name);

        return ownerRepository.save(owner);
    }

    public Wallet createWallet(Long ownerId, String currency, Double balance){
        Wallet existing = walletRepository.findByOwnerIdAndCurrency(ownerId, currency);
        if(existing != null) throw new IllegalArgumentException(currency + " wallet already exist");
        
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        Wallet wallet = new Wallet();
        wallet.setOwner(owner);
        wallet.setCurrency(currency);
        wallet.setBalance(balance);
        wallet.setCreatedDate(LocalDateTime.now());
        wallet.setUpdatedDate(LocalDateTime.now());

        return walletRepository.save(wallet);
    }
}
