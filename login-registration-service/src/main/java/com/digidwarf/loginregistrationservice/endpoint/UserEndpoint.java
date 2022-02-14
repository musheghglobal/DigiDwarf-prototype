package com.digidwarf.loginregistrationservice.endpoint;

import com.digidwarf.loginregistrationservice.request.LoginRequest;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lg-main")
public class UserEndpoint {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity registration(@RequestBody UserRegistrationRequest request){
        return ResponseEntity.ok(userService.registration(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.auth(request));
    }

    @GetMapping("/verify_email/{token}")
    public ResponseEntity<Boolean> verify(@PathVariable("token") String token){
        return ResponseEntity.ok(userService.verifyUserEmail(token));
    }
}
