package org.val.win.mail.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.val.win.mail.contract.BiblioMailSender;

import javax.inject.Named;
import java.util.Properties;

@Named
public class BiblioMailSenderImpl implements BiblioMailSender {

    @Value( "${spring.mail.host}" )
    private String host;

    @Value( "${spring.mail.port}" )
    private int port;

    @Value( "${spring.mail.username}" )
    private String mail;

    @Value( "${spring.mail.password}" )
    private String password;

    @Value( "${spring.mail.properties.mail.smtp.auth}" )
    private String auth;

    @Value( "${spring.mail.properties.mail.smtp.starttls.enable}" )
    private String starttls;


    /**
     * Mise en place de la boite d'envoie des emails
     * @return le mailSender pour envoyer les mails
     */
    @Bean
    public JavaMailSender mailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);

        mailSender.setUsername(mail);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", starttls);
        props.put("mail.debug", "true");

        return mailSender;

    }

}
