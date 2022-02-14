package com.digidwarf.loginregistrationservice.connection;

import com.digidwarf.loginregistrationservice.response.MailVerifyResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mailservice", url = "http://localhost:8083" )
public interface MailServiceConnector {

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    void getPostById(@PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.POST, value = "/mail/sendmail", produces = "application/json")
    boolean sendMailVerification(MailVerifyResponse mailVerifyResponse);
}
