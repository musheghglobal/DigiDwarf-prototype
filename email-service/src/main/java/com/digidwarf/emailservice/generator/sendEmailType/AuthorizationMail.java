package com.digidwarf.emailservice.generator.sendEmailType;


import com.digidwarf.emailservice.dto.MailResponseDto;
import com.digidwarf.emailservice.generator.MailGenerator;
import com.digidwarf.emailservice.service.MailSenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Locale;

@Component("AUTH")
@RequiredArgsConstructor
public class AuthorizationMail implements MailGenerator {

    private final MailSenderType mailSenderType;

    @Override
    public String generate(MailResponseDto mailResponseDto) throws MessagingException {
        mailSenderType.sendHtmlEmail("Welcome",mailResponseDto, Locale.ROOT);
        return "authorization";
    }
}
