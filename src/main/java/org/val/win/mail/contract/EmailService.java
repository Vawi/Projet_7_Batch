package org.val.win.mail.contract;

import org.val.win.model.bean.Ouvrage;

import java.util.List;

public interface EmailService {

    /**
     * Methode pour envoyer des messages
     * @param to le destinataire
     */
    void sendSimpleMessage(String to, List<Ouvrage> listOuvrage);

}
