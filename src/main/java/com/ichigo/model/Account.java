package com.ichigo.model;

public class Account {
    private String name;
    private String accountNumber;
    private double balance;

    public Account(String name, String accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getName(){
        return name;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString(){
        return "Name : " + name + "\n" +
               "Account Number : " + accountNumber + "\n" +
               "Balance : " + balance;
    }
}
