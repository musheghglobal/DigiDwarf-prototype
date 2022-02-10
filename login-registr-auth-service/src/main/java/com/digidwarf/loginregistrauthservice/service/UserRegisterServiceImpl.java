package com.digidwarf.loginregistrauthservice.service;


import com.digidwarf.loginregistrauthservice.exception.*;
import com.digidwarf.loginregistrauthservice.mapper.UserMapper;
import com.digidwarf.loginregistrauthservice.model.Role;
import com.digidwarf.loginregistrauthservice.model.User;
import com.digidwarf.loginregistrauthservice.repository.UserRepository;
import com.digidwarf.loginregistrauthservice.request.UserRequestForLogin;
import com.digidwarf.loginregistrauthservice.request.UserRequestForRegister;
import com.digidwarf.loginregistrauthservice.responce.UserResponse;
import com.digidwarf.loginregistrauthservice.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.%]).{8,18}$";
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    @Override
    public void registerUser(UserRequestForRegister userRequest) {
        Optional<User> findByEmail = userRepository.findByEmail(userRequest.getEmail());
        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            throw new PasswordRepeatException();
        } else if (!userRequest.getPassword().matches(PASSWORD_REGEX)) {
            throw new IncorrectPasswordException();
        }
        if (!userRequest.getEmail().matches(EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
        if (findByEmail.isPresent()) {
            throw new EmailExistException();
        }
        userRequest.setRole(Role.GUEST);
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(mapper.toEntity(userRequest));

    }

    @Override
    public UserResponse loginUser(UserRequestForLogin userRequest) {
        UserResponse userResponse = new UserResponse();
        Optional<User> byEmail = userRepository.findByEmail(userRequest.getEmail());
        if (byEmail.isEmpty()) {
            throw new InvalidLoginOrPasswordException();
        }
        User user = byEmail.get();
        if (passwordEncoder.matches(user.getPassword(), userRequest.getPassword())) {
            throw new InvalidLoginOrPasswordException();
        }
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        String token = jwtTokenUtil.generateToken(user.getEmail());
        userResponse.setToken(token);
        return userResponse;
    }


}
