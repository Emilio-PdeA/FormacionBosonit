package com.formacion.bosonit.EJ2.domain.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(String message){
        super(message);
    }

}
