package com.digidwarf.loginregistrationservice.response;

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
    private String email;
//    private LocalDateTime createdDateTime;
    private boolean isMailVerified;
    private boolean isActive;
    private boolean isOnline;
    private UserRole role;
}
