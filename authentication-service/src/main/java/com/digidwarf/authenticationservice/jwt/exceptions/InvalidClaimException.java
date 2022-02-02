package com.digidwarf.authenticationservice.jwt.exceptions;


public class InvalidClaimException extends JWTVerificationException {
    public InvalidClaimException(String message) {
        super(message);
    }
}
