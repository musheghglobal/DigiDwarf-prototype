package com.digidwarf.loginregistrauthservice.endpoint;

import com.digidwarf.loginregistrauthservice.request.UserRequestForLogin;
import com.digidwarf.loginregistrauthservice.request.UserRequestForRegister;
import com.digidwarf.loginregistrauthservice.responce.UserResponse;
import com.digidwarf.loginregistrauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserEndpoint {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestForRegister userRequest) {
        userService.registerUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/auth")
    public ResponseEntity<?> login(@RequestBody UserRequestForLogin request) {
        UserResponse userResponse = userService.loginUser(request);
        return ResponseEntity.ok().body(userResponse);
    }

}
