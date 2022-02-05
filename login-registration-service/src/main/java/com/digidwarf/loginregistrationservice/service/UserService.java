package com.digidwarf.loginregistrationservice.service;

import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.response.UserAuthResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;

public interface UserService {
    UserResponse registration(UserRegistrationRequest request);

    boolean verifyUser(String email, String token);

    UserAuthResponse auth(UserRegistrationRequest userAuthRequest);
}
