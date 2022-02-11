package com.digidwarf.loginregistrationservice.endpoint;

import com.digidwarf.loginregistrationservice.request.LoginRequest;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import com.digidwarf.loginregistrationservice.service.MailService;
import com.digidwarf.loginregistrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lg-main")
public class ServiceEndpoint {

    private final UserService userService;
    private final MailService mailService;


    @PostMapping("/sign-up")
    public ResponseEntity registration(@RequestBody UserRegistrationRequest request){
        return ResponseEntity.ok(userService.registration(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity login(@RequestBody LoginRequest request){
        mailService.getPosts(new UserResponse());
        return ResponseEntity.ok(userService.auth(request));
    }
}
