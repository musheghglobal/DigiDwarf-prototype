package com.digidwarf.authenticationservice.jwt.exceptions;

public class JWTCreationException extends RuntimeException {
    public JWTCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
