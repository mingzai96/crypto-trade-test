package com.crypto.crpytotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
