package com.practice.jwtapp.service;

import com.practice.jwtapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public SimpleMailMessage createEmail(String subject, String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom("replace-later@mail.com");
        return email;
    }

    public String createResetUrl(String passwordResetToken, String url) {
        return url + passwordResetToken;
    }

    @Async
    public void sendMail(SimpleMailMessage email) throws MailException {
        javaMailSender.send(email);
    }
}
