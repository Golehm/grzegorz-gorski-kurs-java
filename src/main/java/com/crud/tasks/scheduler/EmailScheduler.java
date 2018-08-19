package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                "Currently in database you got: " + size + "task" + endWithS(size)));
    }
    private String endWithS (long size) {
        return size > 1 ? "s" : "" ;
    }
    @Scheduled(cron = "0 0 7 * * *")
    //@Scheduled(fixedDelay = 10000) //for tests
    public void sendCountDaily() {
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, ""));
    }
}
