package com.bank.bankapi.util;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.models.dtos.AccountsDTO;

public class TransformToDTOs {

    public static AccountsDTO fromDTO(Accounts accounts) {
        return new AccountsDTO(accounts.getId(), accounts.getCode(), accounts.getBalance(), accounts.getUserType());
    }

}
