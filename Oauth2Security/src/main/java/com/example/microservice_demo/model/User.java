package com.example.microservice_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;

    private String surname;

    private String patronymic;

    @Column(name = "email", nullable = false)
    @Email
    @NotBlank
    private String email;

    private String password;

    private String phoneNumber;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Date dateOfBirth;

    private String country;

    private String city;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
