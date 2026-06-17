package com.ichigo.service;

import com.ichigo.exceptions.*;
import com.ichigo.model.Account;
import com.ichigo.repository.AccountRepository;

import java.util.Optional;

public class BankService {
    AccountRepository tempRepo;

    public BankService(AccountRepository repo) {
        tempRepo = repo;
    }

    public void createAccount(String name, String accountNumber, double balance) {
        if (balance <= 0) throw new InvalidAmountException("Please Enter a Valid Amount");
        else if (!accountNumber.matches("\\d{10}"))
            throw new InvalidAccountNumber("please give a valid account number");
        else if (tempRepo.findAccountByNumber(accountNumber).isPresent())
            throw new DuplicateAccountException("holder with account number already exist");
        else {
            Account acc = new Account(name, accountNumber, balance);
            tempRepo.addAccount(acc);
        }
    }

    public Account getAccountOrThrow(String accountNo){
        Optional<Account> obj = tempRepo.findAccountByNumber(accountNo);
        if (obj.isPresent()) {
            return obj.get();
        }else {
            throw new AccountNotFoundException("account with this number does not exist");
        }
    }

    public void withdraw(double amount, String accountNo) {
            Account account = getAccountOrThrow(accountNo);
            if (amount > 0 && amount <= account.getBalance()) {
                account.setBalance(account.getBalance() - amount);
            } else {
                throw new InvalidAmountException("amount is not valid");
            }
    }

    public void deposit(double amount, String accountNo) {
            Account account = getAccountOrThrow(accountNo);
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
            } else {
                throw new InvalidAmountException("amount is not valid");
            }
    }
}