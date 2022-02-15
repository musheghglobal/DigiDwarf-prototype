package com.digidwarf.loginregistrationservice.connection;

import com.digidwarf.loginregistrationservice.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "accountserviceconnector", url = "http://localhost:8082" )
public interface AccountServiceConnector {

    @RequestMapping(method = RequestMethod.POST, value = "/acc/v1/user/", produces = "application/json")
    ResponseEntity<Boolean> createAccount(@RequestBody UserResponse userResponse);

}
