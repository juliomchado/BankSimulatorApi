package com.bank.bankapi.models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("accounts")
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Long code;

    private String password;

    private Double balance;

    private String user_type;

    public Accounts(String id, Long code, String password, Double balance, String user_type) {
        this.id = id;
        this.code = code;
        this.password = password;
        this.balance = balance;
        this.user_type = user_type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void addBalance(Double valueToAdd){
        this.balance += valueToAdd;
    }

    public void withdrawBalance(Double valueToRemove){
        this.balance -= valueToRemove;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Accounts)) {
            return false;
        }
        Accounts accounts = (Accounts) o;
        return Objects.equals(id, accounts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
