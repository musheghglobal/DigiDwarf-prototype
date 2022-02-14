package com.digidwarf.loginregistrationservice;

import com.digidwarf.loginregistrationservice.response.MailVerifyResponse;
import com.digidwarf.loginregistrationservice.response.UserResponse;
import com.digidwarf.loginregistrationservice.service.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class LoginRegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginRegistrationServiceApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
