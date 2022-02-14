package com.digidwarf.accountmanagerservice.response;

import com.digidwarf.accountmanagerservice.request.MailType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailResponse {

    private String receiverEmail;
    private String userName;
    private String userSurname;
    private String link;
    private MailType mailType;
}
