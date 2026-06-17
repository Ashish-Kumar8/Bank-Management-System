package com.ichigo.main; //contains main class, application starting point

import com.ichigo.model.Account;
import com.ichigo.repository.AccountRepository;
import com.ichigo.service.BankService;

import java.lang.reflect.AccessibleObject;

public class Main{
    public static void main(String[] args){
        AccountRepository tempRepo = new AccountRepository();
        BankService service = new BankService(tempRepo);
        service.createAccount("Ashish","1234567890",555555.6);
        System.out.println(tempRepo.getAllAccounts());
        service.withdraw(56555,"1234567890");
        System.out.println(tempRepo.findAccountByNumber("1234567890"));
    }
}