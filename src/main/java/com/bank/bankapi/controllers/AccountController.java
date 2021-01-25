package com.bank.bankapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.models.withdrawOrAddBalance;
import com.bank.bankapi.models.dtos.AccountsDTO;
import com.bank.bankapi.services.accounts.AccountsService;
import com.bank.bankapi.util.TransformToDTOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
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
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AccountsDTO>> findAll() {
        List<Accounts> accounts = accountService.findAll();

        List<AccountsDTO> accountsConverted = accounts.stream().map(x -> TransformToDTOs.fromDTO(x))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(accountsConverted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountsDTO> findById(@PathVariable String id) {

        Accounts accounts = accountService.findById(id);

        AccountsDTO accountsDTO = TransformToDTOs.fromDTO(accounts);

        return ResponseEntity.ok().body(accountsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable String id, @RequestBody Accounts accounts) {

        accounts.setId(id);

        boolean ifUpdate = accountService.updateAccounts(accounts);

        if (ifUpdate == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/withdraw_balance/{id}")
    public ResponseEntity<Void> withdrawBalance(@PathVariable String id,
            @RequestBody(required = true) withdrawOrAddBalance withdrawOrAddBalance) {

        Double withdrawValue = withdrawOrAddBalance.getWithdrawBalance();

        boolean ifWithdraw = accountService.withdrawBalance(id, withdrawValue);

        if (ifWithdraw == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/add_balance/{id}")
    public ResponseEntity<Void> addBalance(@PathVariable String id,
            @RequestBody(required = true) withdrawOrAddBalance withdrawOrAddBalance) {

        Double addValue = withdrawOrAddBalance.getAddBalance();

        boolean ifAdd = accountService.addBalance(id, addValue);

        if (ifAdd == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {

        boolean ifDelete = accountService.deleteAccount(id);

        if (ifDelete == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

}
