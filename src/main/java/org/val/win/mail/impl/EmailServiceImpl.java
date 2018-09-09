package org.val.win.mail.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.val.win.mail.contract.EmailService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmailServiceImpl implements EmailService {

    @Inject
    public JavaMailSender mailSender;

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     * @param subject le sujet du mail
     * @param text le contenu du mail
     */
    @Override
    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

    }

}
