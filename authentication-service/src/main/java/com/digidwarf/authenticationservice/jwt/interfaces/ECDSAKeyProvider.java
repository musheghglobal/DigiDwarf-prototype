package com.digidwarf.authenticationservice.jwt.interfaces;

import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/**
 * Elliptic Curve (EC) Public/Private Key provider.
 */
public interface ECDSAKeyProvider extends KeyProvider<ECPublicKey, ECPrivateKey> {
}
