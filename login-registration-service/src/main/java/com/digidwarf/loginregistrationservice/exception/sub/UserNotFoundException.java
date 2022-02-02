package com.digidwarf.loginregistrationservice.exception.sub;

import com.digidwarf.loginregistrationservice.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends UserException {

    @Override
    public String getMessage() {
        return "User not found";
    }
}