package com.credmarg.backend.repository;

import com.credmarg.backend.model.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {

}
