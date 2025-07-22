package com.mpantoja.categories.sandboxhex.domain.exceptions;

import jakarta.persistence.criteria.CriteriaBuilder;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    String fieldValue;
    Integer valueId;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with %s: %s", resourceName,fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer valueId){
        super(String.format("%s not found with %s: %d", resourceName,fieldName, valueId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueId = valueId;
    }
}
