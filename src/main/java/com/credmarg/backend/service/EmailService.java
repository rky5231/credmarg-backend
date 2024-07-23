package com.credmarg.backend.service;

import com.credmarg.backend.model.EmailLog;
import com.credmarg.backend.model.Vendor;
import com.credmarg.backend.repository.EmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailLogRepository emailLogRepository;

    public void sendEmail(Vendor vendor, String message) {
        EmailLog emailLog = new EmailLog();
        emailLog.setRecipientEmail(vendor.getEmail());
        emailLog.setMessage(message);

        emailLogRepository.save(emailLog);

        // Mock email sending
        System.out.println("Sending email to: " + vendor.getEmail());
        System.out.println("Message: " + message);
    }

    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }
}
