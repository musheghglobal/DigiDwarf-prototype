package com.digidwarf.loginregistrationservice.exception.sub;

import com.digidwarf.loginregistrationservice.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FailedAccountCreatedException extends UserException {
    @Override
    public String getMessage() {
        return "fail to create account";
    }
}
