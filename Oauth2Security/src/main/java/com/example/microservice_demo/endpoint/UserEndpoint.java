package com.example.microservice_demo.endpoint;

import com.example.microservice_demo.model.User;
import com.example.microservice_demo.request.UserRequestForLogin;
import com.example.microservice_demo.request.UserRequestForRegister;
import com.example.microservice_demo.responce.UserResponse;
import com.example.microservice_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserEndpoint {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestForRegister userRequest) {
        userService.registerUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestForLogin request) {
        UserResponse userResponse = userService.loginUser(request);
        return ResponseEntity.ok().body(userResponse);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }


}
