package org.val.win.mail.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.val.win.mail.contract.EmailService;

import javax.inject.Inject;
import javax.inject.Named;

@Configuration
@PropertySource("classpath:configurationMail.properties")
@Named
public class EmailServiceImpl implements EmailService {

    @Inject
    public JavaMailSender mailSender;

    @Value( "${mail.sujet}" )
    private String sujet;

    @Value( "${mail.text}" )
    private String textMessage;

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     */
    @Override
    public void sendSimpleMessage(String to) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(sujet);
        message.setText(textMessage);
        mailSender.send(message);

    }

}
