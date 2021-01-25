package com.bank.bankapi.models;

public class Balance {

    private Double withdrawBalance;
    private Double addBalance;

    public Balance(Double withdrawBalance, Double addBalance) {
        this.withdrawBalance = withdrawBalance;
        this.addBalance = addBalance;
    }

    public Double getwithdrawBalance() {
        return this.withdrawBalance;
    }

    public void setwithdrawBalance(Double withdrawBalance) {
        this.withdrawBalance = withdrawBalance;
    }

    public Double getAddBalance() {
        return this.addBalance;
    }

    public void setAddBalance(Double addBalance) {
        this.addBalance = addBalance;
    }

}
