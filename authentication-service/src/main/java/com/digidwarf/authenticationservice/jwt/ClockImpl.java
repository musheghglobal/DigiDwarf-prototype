package com.digidwarf.authenticationservice.jwt;


import com.digidwarf.authenticationservice.jwt.interfaces.Clock;

import java.util.Date;

/**
 * Default Clock implementation used for verification.
 *
 * @see Clock
 * @see JWTVerifier
 * <p>
 * This class is thread-safe.
 */
final class ClockImpl implements Clock {

    ClockImpl() {
    }

    @Override
    public Date getToday() {
        return new Date();
    }
}
