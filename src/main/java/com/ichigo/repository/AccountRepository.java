package com.ichigo.repository;

import com.ichigo.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository{
    private List<Account> accounts = new ArrayList<>();
    public void addAccount(Account account){
        accounts.add(account);
    }
    public Optional<Account> findAccountByNumber(String accountNumber){
        for (Account obj : accounts) {
            if (obj.getAccountNumber().equals(accountNumber))
                return Optional.of(obj);
        }
        return Optional.empty();
    }
    public List<Account> getAllAccounts(){
        List<Account> copyAccount = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            Account obj = accounts.get(i);
            copyAccount.add(new Account(obj.getName(),obj.getAccountNumber(),obj.getBalance()));
        }
        return copyAccount;
    }
}