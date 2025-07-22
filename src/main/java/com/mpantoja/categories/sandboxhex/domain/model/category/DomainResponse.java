package com.mpantoja.categories.sandboxhex.domain.model.category;


public class DomainResponse {

    public String message;
    private Boolean status;

    public DomainResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public DomainResponse() {
    }
}
