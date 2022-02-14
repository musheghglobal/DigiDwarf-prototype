package com.digidwarf.emailservice.mailSender;


import com.digidwarf.emailservice.dto.MailResponseDto;
import com.digidwarf.emailservice.exception.MailWrongTypeException;
import com.digidwarf.emailservice.generator.MailGenerator;
import com.digidwarf.emailservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailProducer {
    @Autowired
    private Map<String, MailGenerator> mailGeneratorMap;
    private final MailService mailService;

    public boolean send(MailResponseDto mailResponseDto) throws MessagingException {
        MailGenerator generator = mailGeneratorMap.get(mailResponseDto.getMailType());
        if (generator == null) {
            throw new MailWrongTypeException("Type dos not exist");
        }
        String generate = generator.generate(mailResponseDto);
        sendMail(generate);
        mailService.saveMail(mailResponseDto.getEmail(), mailResponseDto.getMailType());
        return true;
    }

    private void sendMail(String generate) {
        System.out.println(generate);
    }


}
