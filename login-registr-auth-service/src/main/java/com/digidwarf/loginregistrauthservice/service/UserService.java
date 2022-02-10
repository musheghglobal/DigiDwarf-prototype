package com.digidwarf.loginregistrauthservice.service;

import com.digidwarf.loginregistrauthservice.model.User;
import com.digidwarf.loginregistrauthservice.request.UserRequestForLogin;
import com.digidwarf.loginregistrauthservice.request.UserRequestForRegister;
import com.digidwarf.loginregistrauthservice.responce.UserResponse;

import java.util.List;

public interface UserService {
    void registerUser(UserRequestForRegister userRequest);

    UserResponse loginUser(UserRequestForLogin userRequest);


}
