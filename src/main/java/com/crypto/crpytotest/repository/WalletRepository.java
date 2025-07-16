package com.crypto.crpytotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
    
}
