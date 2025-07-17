package com.crypto.crpytotest.service;

import java.util.List;

import com.crypto.crpytotest.entities.Owner;
import com.crypto.crpytotest.entities.Transaction;
import com.crypto.crpytotest.entities.Wallet;

public interface OwnerService {
    List<Wallet> getWalletByOwnerId(Long ownerId);
    List<Transaction> getTransactionsByOwnerId(Long ownerId);
    Owner createOwner(String name);
    Wallet createWallet(Long ownerId, String currency, Double balance);
}
