package com.digidwarf.accountmanagerservice.mapper;

import com.digidwarf.accountmanagerservice.entity.User;
import com.digidwarf.accountmanagerservice.mapper.config.BaseMapper;
import com.digidwarf.accountmanagerservice.request.UserRequest;
import com.digidwarf.accountmanagerservice.response.UserResponse;
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

    @Override
    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
