package com.formacion.bosonit.shared.exception;

import java.io.Serial;

public class CustomUnprocessableException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CustomUnprocessableException(String message){super(message);}

}
