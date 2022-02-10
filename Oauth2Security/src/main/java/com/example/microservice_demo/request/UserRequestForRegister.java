package com.example.microservice_demo.request;


import com.example.microservice_demo.model.Gender;
import com.example.microservice_demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForRegister {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String patronymic;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;

    @NotNull
    private String passportId;

    @NotNull
    private int age;

    @NotNull
    private Gender gender;

    @NotNull
    private Role role;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private String country;
    @NotNull
    private String phoneNumber;

    @NotNull
    private String city;
}
