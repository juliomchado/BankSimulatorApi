package com.bank.bankapi.util;

import java.util.Optional;

import com.bank.bankapi.models.Accounts;
import com.bank.bankapi.models.dtos.AccountsDTO;

public class TransformToDTOs {

    public static AccountsDTO fromDTO(Accounts accounts) {
        return new AccountsDTO(accounts.getId(), accounts.getCode(), accounts.getBalance(), accounts.getUserType());
    }

	public static AccountsDTO fromDTO(Optional<Accounts> account) {
		return null;
	}

}
