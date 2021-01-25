package com.bank.bankapi.models;

public class withdrawOrAddBalance {

    private Double withdrawBalance;
    private Double addBalance;

    public withdrawOrAddBalance(Double withdrawBalance, Double addBalance) {
        this.withdrawBalance = withdrawBalance;
        this.addBalance = addBalance;
    }

    public Double getWithdrawBalance() {
        return this.withdrawBalance;
    }

    public void setWithdrawBalance(Double withdrawBalance) {
        this.withdrawBalance = withdrawBalance;
    }

    public Double getAddBalance() {
        return this.addBalance;
    }

    public void setAddBalance(Double addBalance) {
        this.addBalance = addBalance;
    }

}
