package com.crypto.crpytotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto.crpytotest.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
}
