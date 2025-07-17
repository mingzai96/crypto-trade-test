package com.crypto.crpytotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.crpytotest.entities.Owner;
import com.crypto.crpytotest.entities.Transaction;
import com.crypto.crpytotest.entities.Wallet;
import com.crypto.crpytotest.service.OwnerService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    // retrieve balance
    @GetMapping("/wallets")
    public List<Wallet> getWallets(@RequestParam Long ownerId){
        return ownerService.getWalletByOwnerId(ownerId);
    }

    // retrieve transactions
    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestParam Long ownerId) {
        return ownerService.getTransactionsByOwnerId(ownerId);
    }

    // Adding this 2 for testing
    @PostMapping("/create")
    public Owner createOwner(@RequestParam String name) {
        return ownerService.createOwner(name);
    }
    
    @PostMapping("/wallet")
    public Wallet createWallet(@RequestParam Long ownerId, @RequestParam String currency, @RequestParam Double balance) {
        return ownerService.createWallet(ownerId, currency, balance);
    }
    
}
