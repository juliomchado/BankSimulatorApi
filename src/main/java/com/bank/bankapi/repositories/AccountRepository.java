package com.bank.bankapi.repositories;

import com.bank.bankapi.models.Accounts;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Accounts, String> {

}
