package org.val.win.mail.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.val.win.mail.contract.BiblioMailSender;

import javax.inject.Named;
import java.util.Properties;

@Named
public class BiblioMailSenderImpl implements BiblioMailSender {

    /**
     * Mise en place de la boite d'envoie des emails
     * @return le mailSender pour envoyer les mails
     */
    @Bean
    public JavaMailSender mailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("vawiopc@gmail.com");
        mailSender.setPassword("vawitestmdp");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;

    }

}
