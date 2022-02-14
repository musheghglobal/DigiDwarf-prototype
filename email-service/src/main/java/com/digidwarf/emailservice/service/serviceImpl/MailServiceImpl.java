package com.digidwarf.emailservice.service.serviceImpl;

import com.digidwarf.emailservice.entity.MailHistory;
import com.digidwarf.emailservice.repository.MailRepository;
import com.digidwarf.emailservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailRepository mailRepository;

    @Override
    public boolean saveMail(String userEmail, String mailType) {

        MailHistory byUserEmail = mailRepository.getByUserEmail(userEmail);
        if (byUserEmail != null) {
            byUserEmail.getSendEmailType().add(mailType);
            mailRepository.save(byUserEmail);
        } else {
            List<String> mailTypes = new ArrayList<>();
            mailTypes.add(mailType);
            mailRepository.save(MailHistory.builder()
                    .sendEmailType(mailTypes)
                    .userEmail(userEmail)
                    .build());
        }
        return true;
    }
}
