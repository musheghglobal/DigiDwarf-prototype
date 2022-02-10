package com.example.microservice_demo.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForLogin {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
