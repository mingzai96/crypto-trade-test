package com.crypto.crpytotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
    List<Wallet> findByOwnerId(Long ownerId);
}
