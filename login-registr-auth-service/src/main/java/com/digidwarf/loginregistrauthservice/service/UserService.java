package com.digidwarf.loginregistrauthservice.service;

import com.digidwarf.loginregistrauthservice.request.UserRequestForLogin;
import com.digidwarf.loginregistrauthservice.request.UserRequestForRegister;
import com.digidwarf.loginregistrauthservice.responce.UserResponse;

public interface UserService {
    void registerUser(UserRequestForRegister userRequest);

    UserResponse loginUser(UserRequestForLogin userRequest);


}
