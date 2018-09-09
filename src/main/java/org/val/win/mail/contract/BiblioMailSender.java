package org.val.win.mail.contract;

import org.springframework.mail.javamail.JavaMailSender;

public interface BiblioMailSender {

    /**
     * Mise en place de la boite d'envoie des emails
     * @return le mailSender pour envoyer les mails
     */
    JavaMailSender mailSender();

}
