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
public class UserRegistrationRequest {
    private String name;
    private String surname;
    private Email email;
    private String password;
    private Location loginLocation;
}
