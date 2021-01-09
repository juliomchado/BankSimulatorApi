package com.bank.bankapi.services.accounts;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private AccountRepository accountRepository;

    public Accounts createAccount(Accounts newAccount) {
        Accounts accountToCreate = accountRepository.insert(newAccount);

        return accountToCreate;

    }
}
