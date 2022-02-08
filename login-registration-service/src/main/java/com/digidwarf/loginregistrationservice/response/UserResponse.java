package com.digidwarf.loginregistrationservice.response;

import com.digidwarf.loginregistrationservice.entity.Email;
import com.digidwarf.loginregistrationservice.entity.Location;
import com.digidwarf.loginregistrationservice.entity.UserRole;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSerialize
public class UserResponse {

    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private Email email;
    private String password;
    private LocalDateTime createdDateTime;
    private boolean isMailVerified;
    private boolean isActive;
    private boolean isOnline;
    private UserRole role;
    private Location loginLocation;
}
