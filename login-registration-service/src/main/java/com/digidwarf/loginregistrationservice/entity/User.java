package com.digidwarf.loginregistrationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_k")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid; 
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDateTime createdDateTime;
    private boolean isMailVerified = false;
    private boolean isActive;
    private boolean isOnline;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    private UUID mailVerifyToken;
}