package com.digidwarf.emailservice.service;

import com.digidwarf.emailservice.dto.MailResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Locale;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailSenderType {

    private final JavaMailSender emailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Async
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @SneakyThrows
    @Async
    public void sendMessageWithAttachment(
            String to, String subject, String text, String pathToAttachment) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        FileSystemResource file
                = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);
        emailSender.send(message);
    }

    @Async
    public void sendHtmlEmail(String subject, MailResponseDto mailResponseDto,
                              Locale locale) throws MessagingException {
        final Context ctx = new Context(locale);
        ctx.setVariable("name", mailResponseDto.getName() + " " + mailResponseDto.getSurname());
        String mailVerificationLink = mailResponseDto.getMailVerificationLink();
        if (mailVerificationLink != null) {
            ctx.setVariable("url", mailVerificationLink);
        }
        String mailType = mailResponseDto.getMailType();
        final String htmlContent = templateEngine.process("mail/" + mailType, ctx);
        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = emailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject(subject);
        message.setTo(mailResponseDto.getEmail());
        message.setText(htmlContent, true); // true = isHtml
        // Send mail
        this.emailSender.send(mimeMessage);
        log.info("Email is successfully send to email {}", mailResponseDto.getEmail());
    }

}
