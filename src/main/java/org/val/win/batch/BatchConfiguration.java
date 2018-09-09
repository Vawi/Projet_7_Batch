package org.val.win.batch;

import org.joda.time.LocalDate;
import org.val.win.mail.contract.EmailService;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

public class BatchConfiguration {


    @Inject
    private P7Service p7Service;

    @Inject
    private EmailService emailService;

    private Utilisateur pUtilisateur;

    private String sujet = "Retard Emprunt";
    private String textMessage = "Vous avez un emprunt en retard, veuillez le rendre au plus vite";

    /**
     * Recuperer la liste des emprunts en retard
     * @return
     */
    public List<Emprunt> ListEmpruntRetard() {

        List<Emprunt> vListEmprunt = p7Service.getListEmprunt().getItem();

        List<Emprunt> ListEmpruntRetard = vListEmprunt.stream()
                .filter(p -> p.getDateFin().toGregorianCalendar()
                        .after(LocalDate.now()))
                        .collect(Collectors.toList());
        return ListEmpruntRetard;
    }

    /**
     * Methode pour envoyer un emai en cas de retard
     *
     */
    public void EnvoiRetard() {

        List<Emprunt> vListEmprunt = ListEmpruntRetard();

        for (int i = 0; i < vListEmprunt.size(); i++) {
            pUtilisateur = p7Service.getUtilisateur(vListEmprunt.get(i).getIdUtilisateur());
            emailService.sendSimpleMessage(pUtilisateur.getMail(), sujet, textMessage);
        }

    }

}
