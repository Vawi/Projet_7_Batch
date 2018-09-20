package org.val.win.mail.contract;

public interface EmailService {

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     */
    void sendSimpleMessage(String to);

}
