package com.ichigo.exceptions;

public class InvalidBalanceException extends RuntimeException{
    public InvalidBalanceException(String message){
        super(message);
    }
}
