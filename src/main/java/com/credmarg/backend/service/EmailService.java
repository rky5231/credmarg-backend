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

    public void sendEmail(String email, String name, String upi) {
        EmailLog emailLog = new EmailLog();

        emailLog.setRecipientEmail(email);
        String message = String.format("Sending payments to vendor %s at upi %s", name, upi);

        emailLog.setMessage(message);

        emailLogRepository.save(emailLog);

        // Mock email sending
        System.out.println("Sending email to: " + email);
        System.out.println("Message: " + message);
    }

    public void sendEmailToVendors(List<Vendor> vendorsList){

        for (Vendor v: vendorsList){
            sendEmail(v.getEmail(),v.getName(),v.getUpi());
        }
    }

    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }
}
