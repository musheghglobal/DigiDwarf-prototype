package com.digidwarf.authenticationservice.jwt.algorithms;


import com.digidwarf.authenticationservice.jwt.exceptions.SignatureGenerationException;
import com.digidwarf.authenticationservice.jwt.exceptions.SignatureVerificationException;
import com.digidwarf.authenticationservice.jwt.interfaces.DecodedJWT;

import java.util.Base64;

class NoneAlgorithm extends Algorithm {

    NoneAlgorithm() {
        super("none", "none");
    }

    @Override
    public void verify(DecodedJWT jwt) throws SignatureVerificationException {
        try {
            byte[] signatureBytes = Base64.getUrlDecoder().decode(jwt.getSignature());

            if (signatureBytes.length > 0) {
                throw new SignatureVerificationException(this);
            }
        } catch (IllegalArgumentException e) {
            throw new SignatureVerificationException(this, e);
        }
    }

    @Override
    public byte[] sign(byte[] headerBytes, byte[] payloadBytes) throws SignatureGenerationException {
        return new byte[0];
    }

    @Override
    @Deprecated
    public byte[] sign(byte[] contentBytes) throws SignatureGenerationException {
        return new byte[0];
    }
}
