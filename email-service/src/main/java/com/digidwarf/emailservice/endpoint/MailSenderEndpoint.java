package com.digidwarf.emailservice.endpoint;

import com.digidwarf.emailservice.dto.MailResponseDto;
import com.digidwarf.emailservice.mailSender.MailProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailSenderEndpoint {

    private final MailProducer mailProducer;

    @PostMapping("/sendmail")
    public ResponseEntity send(@RequestBody MailResponseDto mailResponseDto) throws MessagingException {
        return ResponseEntity.ok(mailProducer.send(mailResponseDto));
    }


}
