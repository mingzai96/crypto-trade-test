package com.crypto.crpytotest.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crypto.crpytotest.entities.Owner;
import com.crypto.crpytotest.service.OwnerService;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
    
    @Autowired
    private OwnerService ownerService;

    @PostConstruct
    public void seedData(){
        // Assumption, User's initial wallet balance 50,000 USDT in DB record.
        Owner owner = ownerService.createOwner("Test");
        ownerService.createWallet(owner.getId(), "USDT", 50000.0);
    }
}
