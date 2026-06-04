package com.ichigo.service;

import com.ichigo.exceptions.DuplicateAccountException;
import com.ichigo.exceptions.InvalidAccountNumber;
import com.ichigo.exceptions.InvalidBalanceException;
import com.ichigo.model.Account;
import com.ichigo.repository.AccountRepository;

public class BankService{
    AccountRepository tempRepo;
    public BankService(AccountRepository repo){
       tempRepo = repo;
    }
    public void createAccount(String name, String accountNumber, double balance) {
        if (balance <= 0) throw new InvalidBalanceException("Please Enter a Valid Amount");
        else if (!accountNumber.matches("\\d{10}"))
            throw new InvalidAccountNumber("please give a valid account number");
        else if(tempRepo.findAccountByNumber(accountNumber).isPresent())
            throw new DuplicateAccountException("holder with account number already exist");
        else{
        Account acc = new Account(name, accountNumber, balance);
        tempRepo.addAccount(acc);
        }
    }
}
