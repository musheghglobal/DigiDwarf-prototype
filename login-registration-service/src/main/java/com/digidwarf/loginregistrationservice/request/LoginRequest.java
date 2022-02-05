package com.digidwarf.loginregistrationservice.request;

import com.digidwarf.loginregistrationservice.entity.Email;
import com.digidwarf.loginregistrationservice.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private Email email;
    private String password;
    private String googleAuth;
    private Location loginLocation;
}
