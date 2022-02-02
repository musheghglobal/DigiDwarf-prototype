package com.digidwarf.loginregistrationservice.exception.sub;

import com.digidwarf.loginregistrationservice.exception.EmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailNotFoundException extends EmailException {
    @Override
    public String getMessage() {
        return "email not found";
    }
}