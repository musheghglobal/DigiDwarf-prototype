package com.digidwarf.loginregistrationservice.service;

import com.digidwarf.loginregistrationservice.response.MailVerifyResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mailservice")
public interface MailService {

    @RequestMapping(method = RequestMethod.POST, value = "http:/localhost:8082/new_user", produces = "application/json")
    boolean createAccount(@RequestBody UserResponse userResponse);

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    void getPostById(@PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.POST, value = "http://localhost:8083/sendmail", produces = "application/json")
    boolean sendMailVerification(MailVerifyResponse mailVerifyResponse);
}
