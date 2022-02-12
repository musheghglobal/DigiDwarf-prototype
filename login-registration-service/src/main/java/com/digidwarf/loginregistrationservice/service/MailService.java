package com.digidwarf.loginregistrationservice.service;

import com.digidwarf.loginregistrationservice.response.AccountResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mailservice", url = "http://localhost:8082/")
public interface MailService {

    @RequestMapping(method = RequestMethod.POST, value = "/new_user", produces = "application/json")
    boolean createAccount(@RequestBody UserResponse userResponse);

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    void getPostById(@PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.POST, value = "/verificationMail", produces = "application/json")
    boolean sendMailVerification(AccountResponse accountResponse);
}
