package com.digidwarf.loginregistrationservice.exception.sub;

import com.digidwarf.loginregistrationservice.exception.TokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MailVerifyTokenException extends TokenException {
}
