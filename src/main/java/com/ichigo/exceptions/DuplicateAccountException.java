package com.ichigo.exceptions;

public class DuplicateAccountException extends RuntimeException{
    public DuplicateAccountException(String msg){
        super(msg);
    }
}
