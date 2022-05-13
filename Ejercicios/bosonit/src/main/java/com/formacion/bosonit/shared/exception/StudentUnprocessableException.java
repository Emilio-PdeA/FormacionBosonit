package com.formacion.bosonit.shared.exception;

import java.io.Serial;


public class StudentUnprocessableException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public StudentUnprocessableException(String message){super(message);}

}
