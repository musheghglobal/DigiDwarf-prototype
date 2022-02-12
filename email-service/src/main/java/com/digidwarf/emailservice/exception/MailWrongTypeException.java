package com.digidwarf.emailservice.exception;

public class MailWrongTypeException extends RuntimeException{

    public MailWrongTypeException(String message) {
        super();
    }

    @Override
    public String getMessage() {
        return "Type does not exist";
    }
}
