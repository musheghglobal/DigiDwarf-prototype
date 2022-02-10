package com.digidwarf.loginregistrauthservice.mapper;


import com.digidwarf.loginregistrauthservice.mapper.config.BaseMapper;
import com.digidwarf.loginregistrauthservice.model.User;
import com.digidwarf.loginregistrauthservice.request.UserRequestForRegister;
import com.digidwarf.loginregistrauthservice.responce.UserResponse;
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
