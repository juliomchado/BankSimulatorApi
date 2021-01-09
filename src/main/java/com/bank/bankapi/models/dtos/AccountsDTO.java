package com.bank.bankapi.models.dtos;

import java.io.Serializable;

import com.bank.bankapi.models.enums.UserType;

public class AccountsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Long code;

    private Double balance;

    private String user_type;

    public AccountsDTO(String id, Long code, Double balance, String user_type) {
        this.id = id;
        this.code = code;
        this.balance = balance;
        this.user_type = user_type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUserType() {
        return this.user_type;
    }

    public void setUserType(String user_type) {
        this.user_type = user_type;
    }

}
