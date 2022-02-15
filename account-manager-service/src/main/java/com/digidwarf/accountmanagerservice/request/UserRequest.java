package com.digidwarf.accountmanagerservice.request;

import com.digidwarf.accountmanagerservice.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

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