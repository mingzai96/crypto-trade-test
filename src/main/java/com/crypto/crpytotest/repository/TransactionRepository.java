package com.crypto.crpytotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findByOwnerId(Long ownerId);
}
