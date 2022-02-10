package com.digidwarf.loginregistrationservice.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonObjectSerializer;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userk")
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
    private boolean isMailVerified;
    private boolean isActive;
    private boolean isOnline;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    private UUID mailVerifyToken;

}
