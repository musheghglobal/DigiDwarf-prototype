package com.digidwarf.accountmanagerservice.endpoint;

import com.digidwarf.accountmanagerservice.request.UserRequest;
import com.digidwarf.accountmanagerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/acc")
public class UserEndpoint {

    private final UserService userService;

    @PostMapping
    public void test(){
        System.out.println("test endpoint");
    }

    @PostMapping("/new_user")
    public ResponseEntity<Boolean> createNewAccount(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.add(userRequest));
    }
}
