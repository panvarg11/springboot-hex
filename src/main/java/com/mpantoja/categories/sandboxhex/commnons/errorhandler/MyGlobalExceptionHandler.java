package com.mpantoja.categories.sandboxhex.commnons.errorhandler;

import com.mpantoja.categories.sandboxhex.domain.exceptions.DomainException;
import com.mpantoja.categories.sandboxhex.domain.exceptions.ResourceNotFoundException;
import com.mpantoja.categories.sandboxhex.domain.exceptions.TextLengthViolationException;
import com.mpantoja.categories.sandboxhex.domain.model.category.DomainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalExceptionHandler {


    @ExceptionHandler(TextLengthViolationException.class)
    public ResponseEntity<String> myTextViolationExc(TextLengthViolationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<DomainResponse> myDomainExceptionExc(DomainException e){
        DomainResponse response = new DomainResponse(e.getMessage(), false);
        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DomainResponse> myResourceNotfound(ResourceNotFoundException e){
        DomainResponse response = new DomainResponse(e.getMessage(),false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }




}
