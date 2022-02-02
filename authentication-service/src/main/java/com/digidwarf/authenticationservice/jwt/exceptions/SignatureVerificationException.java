package com.digidwarf.authenticationservice.jwt.exceptions;


import com.digidwarf.authenticationservice.jwt.algorithms.Algorithm;

public class SignatureVerificationException extends JWTVerificationException {
    public SignatureVerificationException(Algorithm algorithm) {
        this(algorithm, null);
    }

    public SignatureVerificationException(Algorithm algorithm, Throwable cause) {
        super("The Token's Signature resulted invalid when verified using the Algorithm: " + algorithm, cause);
    }
}
