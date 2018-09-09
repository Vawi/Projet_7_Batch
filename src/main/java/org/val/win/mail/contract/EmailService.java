package org.val.win.mail.contract;

public interface EmailService {

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     * @param subject le sujet du mail
     * @param text le contenu du mail
     */
    void sendSimpleMessage(String to, String subject, String text);

}
