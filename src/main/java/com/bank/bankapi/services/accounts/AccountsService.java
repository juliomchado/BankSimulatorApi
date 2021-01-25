package com.bank.bankapi.services.accounts;

import java.util.List;
import java.util.Optional;

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

    public Accounts findById(String id) {
        Optional<Accounts> accounts = accountRepository.findById(id);

        return accounts.orElseThrow(() -> new RuntimeException("Object not exists"));
    }

    public boolean updateAccounts(Accounts newAccount) {
        Accounts account = findById(newAccount.getId());

        if (account != null) {

            account.setCode(newAccount.getCode());
            account.setBalance(newAccount.getBalance());
            account.setUserType(newAccount.getUserType());

            accountRepository.save(account);

            return true;
        }

        return false;
    }

    public boolean deleteAccount(String id) {
        Accounts account = findById(id);

        if (account != null) {
            accountRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public boolean withdrawAccount(String id, Double value) {
        Accounts account = findById(id);

        if (account != null) {
            account.withdrawBalance(value);

            accountRepository.save(account);
            return true;
        }

        return false;
    }

}
