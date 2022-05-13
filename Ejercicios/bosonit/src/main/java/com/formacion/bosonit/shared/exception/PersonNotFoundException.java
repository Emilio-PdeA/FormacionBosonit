package com.formacion.bosonit.shared.exception;

import java.io.Serial;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(String message){
        super(message);
    }

}
