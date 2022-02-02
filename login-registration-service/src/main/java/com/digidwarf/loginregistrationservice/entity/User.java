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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;
    private String name;
    private String surname;
    @ManyToOne
    private Email email;
    private LocalDateTime createdDateTime;
    private boolean isMailVerified;
    private boolean isActive;
    private boolean isOnline;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    @ManyToOne
    private Location loginLocation;
}
