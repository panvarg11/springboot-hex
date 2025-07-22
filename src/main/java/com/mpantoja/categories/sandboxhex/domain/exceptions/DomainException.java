package com.mpantoja.categories.sandboxhex.domain.exceptions;

public class DomainException extends RuntimeException{

    private static Long serialVersionUID;

    public DomainException(){

    }

    public DomainException(String message){
        super(message);
    }

}
