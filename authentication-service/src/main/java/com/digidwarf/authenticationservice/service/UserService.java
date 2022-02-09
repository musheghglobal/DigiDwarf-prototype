package com.digidwarf.authenticationservice.service;


import com.digidwarf.authenticationservice.model.User;
import com.digidwarf.authenticationservice.request.UserRequestForLogin;
import com.digidwarf.authenticationservice.request.UserRequestForRegister;
import com.digidwarf.authenticationservice.responce.UserResponse;

import java.util.List;

public interface UserService {
    void registerUser(UserRequestForRegister userRequest);

    UserResponse loginUser(UserRequestForLogin userRequest);

    List<User> findAllUsers();


}
