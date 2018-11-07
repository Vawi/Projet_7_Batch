package org.val.win.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.batch.EmpruntService;
import org.val.win.mail.contract.EmailService;
import org.val.win.mail.impl.EmailServiceImpl;

public enum ContextLoader {

    INSTANCE();

    private EmpruntService empruntService;

    private EmailService emailService;

    ContextLoader() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        empruntService = (EmpruntService) context.getBean("empruntService");
        emailService = (EmailServiceImpl)context.getBean("emailServiceImpl");
    }

    public EmpruntService getEmpruntService() {
        return empruntService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

}
