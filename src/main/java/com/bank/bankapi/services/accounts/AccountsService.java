package com.bank.bankapi.services.accounts;

import java.util.List;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean createAccount(Accounts newAccount) {

        Accounts accountToCreate = accountRepository.insert(newAccount);

        if (accountToCreate != null) {
            return true;
        }

        return false;

    }

    public List<Accounts> findAll() {
        return accountRepository.findAll();
    }
}
