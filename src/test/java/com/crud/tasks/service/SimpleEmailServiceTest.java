package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "Test", "Test Message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        //if(mail.getToCc() != null) {
         //   mailMessage.setCc(mail.getToCc());
        //}

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }
    /*
    @Test
    public void shouldSendEmailCcNotNull() {
        //Given
        Mail mailCc = new Mail("test@test.com", "Test", "Test Message","testbest@test.com");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mailCc.getMailTo());
        mailMessage.setSubject(mailCc.getSubject());
        mailMessage.setText(mailCc.getMessage());
        if(mailCc.getToCc() != null) {
            mailMessage.setCc(mailCc.getToCc());
        }

        //When
        simpleEmailService.send(mailCc);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }*/
}