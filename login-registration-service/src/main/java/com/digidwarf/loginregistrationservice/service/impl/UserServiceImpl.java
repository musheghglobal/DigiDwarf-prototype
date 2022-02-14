package com.digidwarf.loginregistrationservice.service.impl;

import com.digidwarf.loginregistrationservice.entity.User;
import com.digidwarf.loginregistrationservice.exception.sub.*;
import com.digidwarf.loginregistrationservice.mapper.UserMapper;
import com.digidwarf.loginregistrationservice.repository.UserRepository;
import com.digidwarf.loginregistrationservice.request.LoginRequest;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.response.*;
import com.digidwarf.loginregistrationservice.service.MailService;
import com.digidwarf.loginregistrationservice.service.UserService;
import com.digidwarf.loginregistrationservice.token.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final MailService mailService;

    @Value("${dwarf.mail.verify.url}")
    private String MAIL_VERIFY_URL;

    @Override
    public UserResponse registration(UserRegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailRepeatingException();
        }
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMailVerifyToken(UUID.randomUUID());
        User save = userRepository.save(user);
        mailService.sendMailVerification(MailVerifyResponse.builder()
                .name(save.getName())
                .surname(save.getSurname())
                .email(save.getEmail())
                .mailVerificationLink(MAIL_VERIFY_URL + user.getMailVerifyToken())
                .mailType(MailType.AUTH)
                .build());
        return userMapper.toResponse(save);
    }

    @Override
    public boolean verifyUserEmail(String token) {
        User user = userRepository.findByMailVerifyToken(token).orElseThrow(MailVerifyTokenException::new);
        if (user.getMailVerifyToken().equals(UUID.fromString(token))) {
            user.setMailVerified(true);
            user.setMailVerifyToken(null);
            user.setUuid(UUID.randomUUID());
            User save = userRepository.save(user);
            boolean accountCreated = mailService.createAccount(userMapper.toResponse(save));
            if (!accountCreated){
                throw new FailedAccountCreatedException();
            }
            return true;
        }
        return false;
    }

    @Override
    public UserAuthResponse auth(LoginRequest loginRequest) throws UserNotFoundException {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(UserNotFoundException::new);
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new UserAuthResponse(
                    jwtTokenUtil.generateToken(user.getEmail()),
                    userMapper.toResponse(user));
        }
        throw new UserNotFoundException();
    }
}
