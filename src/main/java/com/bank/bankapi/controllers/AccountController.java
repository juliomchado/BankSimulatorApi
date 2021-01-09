package com.bank.bankapi.controllers;

import com.bank.bankapi.models.dtos.AccountsDTO;
import com.bank.bankapi.models.enums.UserType;
import com.bank.bankapi.services.accounts.AccountsService;
import com.bank.bankapi.models.Accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountsService accountService;

    @PostMapping
    public ResponseEntity<AccountsDTO> createAccount(@RequestBody Accounts newAccount) {

        if (newAccount == null) {
            return ResponseEntity.badRequest().build();
        }
        newAccount.setUserType(newAccount.getUserType().toUpperCase());

        Accounts accountCreated = accountService.createAccount(newAccount);
        // new Accounts(newAccount.getId(), newAccount.getCode(),
        // newAccount.getPassword(), 0.0, newAccount.getUserType())

        AccountsDTO accountConvertedToAccountDTO = new AccountsDTO(accountCreated.getId(), accountCreated.getCode(),
                accountCreated.getBalance(), accountCreated.getUserType());

        return ResponseEntity.ok().body(accountConvertedToAccountDTO);
    }
}
