package com.digidwarf.authenticationservice.jwt.exceptions;


import com.digidwarf.authenticationservice.jwt.algorithms.Algorithm;

public class SignatureGenerationException extends JWTCreationException {
    public SignatureGenerationException(Algorithm algorithm, Throwable cause) {
        super("The Token's Signature couldn't be generated when signing using the Algorithm: " + algorithm, cause);
    }
}
