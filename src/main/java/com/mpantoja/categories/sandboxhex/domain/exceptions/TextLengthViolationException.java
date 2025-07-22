package com.mpantoja.categories.sandboxhex.domain.exceptions;

public class TextLengthViolationException extends RuntimeException{

    int min;
    int max;

    public TextLengthViolationException(String fieldName, int min, int max) {
        super(String.format("%s must be between %d and %d characters long.",fieldName,min,max));
        this.min = min;
        this.max=max;
    }

}
