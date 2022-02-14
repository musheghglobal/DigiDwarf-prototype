package com.digidwarf.accountmanagerservice.endpoint;

import com.digidwarf.accountmanagerservice.request.UserRequest;
import com.digidwarf.accountmanagerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/acc/v1/user")
public class UserEndpoint {

    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<Boolean> createNewAccount(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.add(userRequest));
    }
}
