package com.crypto.crpytotest.dto;

public class TradeParamDTO {
    private Long ownerId;
    private String baseCurrency;
    private String quoteCurrency;
    private double amount;

    // --- Getters ---
    public Long getOwnerId() {
        return ownerId;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public Double getAmount(){
        return amount;
    }

    // --- Setters ---
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
    
    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
