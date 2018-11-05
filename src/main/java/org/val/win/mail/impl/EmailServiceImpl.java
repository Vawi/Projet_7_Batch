package org.val.win.mail.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.val.win.mail.contract.EmailService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class EmailServiceImpl implements EmailService {

    public static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);

    @Inject
    public JavaMailSender mailSender;

    @Value( "${mail.sujet}" )
    private String sujet;

    @Value( "${mail.text}" )
    private String textMessage;

    @Value( "${mail.activation}")
    private Boolean activation;

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     */
    @Override
    public void sendSimpleMessage(String to, List<String> listOuvrage) {

        if (!activation) {

            logger.warn("Envoie d\'email désactivé");

        } else {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(sujet);
            message.setText(textMessage + listOuvrage);
            mailSender.send(message);
        }


    }

}
