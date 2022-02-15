package com.digidwarf.accountmanagerservice.service.impl;

import com.digidwarf.accountmanagerservice.entity.User;
import com.digidwarf.accountmanagerservice.exception.UserWithEmailRepeatingException;
import com.digidwarf.accountmanagerservice.mapper.UserMapper;
import com.digidwarf.accountmanagerservice.repository.UserRepository;
import com.digidwarf.accountmanagerservice.request.UserRequest;
import com.digidwarf.accountmanagerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Boolean add(UserRequest userRequest) {
        if (userRepository.findUserByEmail(userRequest.getEmail()).isPresent()) {
            throw new  UserWithEmailRepeatingException();
        }
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
        return Boolean.TRUE;
    }
}
