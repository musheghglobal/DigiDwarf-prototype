package com.digidwarf.loginregistrationservice.exception.sub;

import com.digidwarf.loginregistrationservice.exception.EmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailRepeatingException extends EmailException {
    @Override
    public String getMessage() {
        return "email can not be repeating";
    }
}