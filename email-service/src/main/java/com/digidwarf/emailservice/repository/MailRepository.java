package com.digidwarf.emailservice.repository;

import com.digidwarf.emailservice.entity.MailHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailHistory,Long> {

    MailHistory getByUserEmail(String userEmail);

}
