package com.bank.bankapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.models.dtos.AccountsDTO;
import com.bank.bankapi.services.accounts.AccountsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

        boolean accountCreated = accountService.createAccount(newAccount);

        if (accountCreated == false) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AccountsDTO>> findAll() {
        List<Accounts> accounts = accountService.findAll();

        List<AccountsDTO> accountsConverted = accounts.stream()
                .map(x -> new AccountsDTO(x.getId(), x.getCode(), x.getBalance(), x.getUserType()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(accountsConverted);
    }

}
