package com.digidwarf.loginregistrationservice.service.impl;

import com.digidwarf.loginregistrationservice.entity.User;
import com.digidwarf.loginregistrationservice.exception.sub.EmailNotFoundException;
import com.digidwarf.loginregistrationservice.exception.sub.EmailRepeatingException;
import com.digidwarf.loginregistrationservice.exception.sub.UserNotFoundException;
import com.digidwarf.loginregistrationservice.mapper.UserMapper;
import com.digidwarf.loginregistrationservice.repository.UserRepository;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.response.UserAuthResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import com.digidwarf.loginregistrationservice.service.UserService;
import com.digidwarf.loginregistrationservice.token.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public UserResponse registration(UserRegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail().getEmail()).isPresent()) {
            throw new EmailRepeatingException();
        }
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public boolean verifyUser(String email, String token) {
        User user = userRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);
        if (user.getMailVerifyToken().equals(UUID.fromString(token))) {
            user.setMailVerified(true);
            user.setMailVerifyToken(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public UserAuthResponse auth(UserRegistrationRequest userAuthRequest) throws UserNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(userAuthRequest.getEmail().getEmail());
        if (byEmail.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = byEmail.get();
        if (passwordEncoder.matches(userAuthRequest.getPassword(), user.getPassword())) {
            return new UserAuthResponse(
                    jwtTokenUtil.generateToken(user.getEmail().getEmail()),
                    userMapper.toResponse(user));
        }
        throw new UserNotFoundException();
    }
}
