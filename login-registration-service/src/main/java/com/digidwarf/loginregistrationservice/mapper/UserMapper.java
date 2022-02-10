package com.digidwarf.loginregistrationservice.mapper;

import com.digidwarf.loginregistrationservice.entity.User;
import com.digidwarf.loginregistrationservice.mapper.config.BaseMapper;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.request.UserRequest;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserRequest, UserResponse> {

    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }

    public User toEntity(UserRegistrationRequest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }

    @Override
    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
