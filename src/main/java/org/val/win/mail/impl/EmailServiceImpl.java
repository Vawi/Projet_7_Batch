package org.val.win.mail.impl;

import org.springframework.mail.SimpleMailMessage;
import org.val.win.mail.contract.BiblioMailSender;
import org.val.win.mail.contract.EmailService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmailServiceImpl implements EmailService {

    @Inject
    public BiblioMailSender biblioMailSender;

    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        //biblioMailSender.send(message);

    }

}
