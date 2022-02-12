package com.digidwarf.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponseDto {

    private String email;
    private String userName;
    private String userSurname;
    private String mailType;
    private String link;

}
