package com.crypto.crpytotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.entities.Ticker;

public interface TickerRepository extends JpaRepository<Ticker, String> {
    
}
