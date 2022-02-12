package com.digidwarf.emailservice.mailSender;


import com.digidwarf.emailservice.dto.MailResponseDto;
import com.digidwarf.emailservice.exception.MailWrongTypeException;
import com.digidwarf.emailservice.generator.MailGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Locale;
import java.util.Map;

@Service
public class MailProducer {
    @Autowired
    private Map<String, MailGenerator> mailGeneratorMap;

    public String send(MailResponseDto mailResponseDto) throws MessagingException {
        MailGenerator generator = mailGeneratorMap.get(mailResponseDto.getMailType());
        if (generator==null){
            throw new  MailWrongTypeException("Type dos not exist");
        }
        String generate = generator.generate(mailResponseDto);
        sendMail(generate);
        return generate;
    }

    private void sendMail(String generate) {
        System.out.println(generate);
    }


}
