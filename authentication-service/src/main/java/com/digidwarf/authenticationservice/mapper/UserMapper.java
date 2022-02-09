package com.digidwarf.authenticationservice.mapper;


import com.digidwarf.authenticationservice.mapper.config.BaseMapper;
import com.digidwarf.authenticationservice.model.User;
import com.digidwarf.authenticationservice.request.UserRequestForRegister;
import com.digidwarf.authenticationservice.responce.UserResponse;
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
