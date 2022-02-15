package com.digidwarf.loginregistrationservice.service.impl;

import com.digidwarf.loginregistrationservice.connection.AccountServiceConnector;
import com.digidwarf.loginregistrationservice.connection.MailServiceConnector;
import com.digidwarf.loginregistrationservice.entity.User;
import com.digidwarf.loginregistrationservice.exception.sub.EmailRepeatingException;
import com.digidwarf.loginregistrationservice.exception.sub.FailedAccountCreatedException;
import com.digidwarf.loginregistrationservice.exception.sub.MailVerifyTokenException;
import com.digidwarf.loginregistrationservice.exception.sub.UserNotFoundException;
import com.digidwarf.loginregistrationservice.mapper.UserMapper;
import com.digidwarf.loginregistrationservice.repository.UserRepository;
import com.digidwarf.loginregistrationservice.request.LoginRequest;
import com.digidwarf.loginregistrationservice.request.UserRegistrationRequest;
import com.digidwarf.loginregistrationservice.response.MailType;
import com.digidwarf.loginregistrationservice.response.MailVerifyResponse;
import com.digidwarf.loginregistrationservice.response.UserAuthResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import com.digidwarf.loginregistrationservice.service.UserService;
import com.digidwarf.loginregistrationservice.token.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final MailServiceConnector mailServiceConnector;
    private final AccountServiceConnector accountServiceConnector;


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
        mailServiceConnector.sendMailVerification(MailVerifyResponse.builder()
                .name(save.getName())
                .surname(save.getSurname())
                .email(save.getEmail())
                .mailVerificationLink(MAIL_VERIFY_URL + save.getMailVerifyToken())
                .mailType(MailType.AUTH)
                .build());
        return userMapper.toResponse(save);
    }

    @Override
    public boolean verifyUserEmail(String token) {
        Optional<User> userOptional = userRepository.findUserByMailVerifyToken(UUID.fromString(token));
        if (userOptional.isEmpty()) {
            return false;
        }
        User user = userOptional.get();
        if (user.getMailVerifyToken().equals(UUID.fromString(token))) {
            user.setMailVerified(true);
            user.setMailVerifyToken(null);
            user.setUuid(UUID.randomUUID());
            User save = userRepository.save(user);
            ResponseEntity<Boolean> accountCreated = accountServiceConnector.createAccount(userMapper.toResponse(save));
            if (!accountCreated.getStatusCode().equals(HttpStatus.OK)) {
                log.error("account dont created in account service");
                throw new FailedAccountCreatedException();
            }
            return true;
        }
        throw new MailVerifyTokenException("user by email:" + user.getEmail() +
                "and by token:" + token + "founded, but not verified correctly");
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
