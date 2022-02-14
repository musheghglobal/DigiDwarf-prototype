package com.digidwarf.emailservice.generator;

import com.digidwarf.emailservice.dto.MailResponseDto;

import javax.mail.MessagingException;

public interface MailGenerator {

    String generate(MailResponseDto mailResponseDto) throws MessagingException;

}
