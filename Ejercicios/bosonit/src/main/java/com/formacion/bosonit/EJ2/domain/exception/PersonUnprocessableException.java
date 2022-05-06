package com.formacion.bosonit.EJ2.domain.exception;

import java.io.Serial;


public class PersonUnprocessableException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public PersonUnprocessableException(String message){super(message);}

}
