package com.example.microservice_demo.service;

import com.example.microservice_demo.model.User;
import com.example.microservice_demo.request.UserRequestForLogin;
import com.example.microservice_demo.request.UserRequestForRegister;
import com.example.microservice_demo.responce.UserResponse;

import java.util.List;

public interface UserService {
    void registerUser(UserRequestForRegister userRequest);

    UserResponse loginUser(UserRequestForLogin userRequest);

    List<User> findAllUsers();


}
