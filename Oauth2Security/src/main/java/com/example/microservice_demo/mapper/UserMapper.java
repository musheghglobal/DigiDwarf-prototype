package com.example.microservice_demo.mapper;


import com.example.microservice_demo.mapper.config.BaseMapper;
import com.example.microservice_demo.model.User;
import com.example.microservice_demo.request.UserRequestForRegister;
import com.example.microservice_demo.responce.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserRequestForRegister, UserResponse> {
    private final ModelMapper mapper;

    @Override
    public User toEntity(UserRequestForRegister userRequest) {
        User user = mapper.map(userRequest, User.class);
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return userResponse;
    }
}
