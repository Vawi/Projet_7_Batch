package org.val.win.batch;

import org.joda.time.LocalDate;
import org.val.win.mail.contract.EmailService;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class EmpruntService {

    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();

    @Inject
    private EmailService emailService;

    private Utilisateur pUtilisateur;

    private String sujet = "Retard";
    private String textMessage = "Vous avez un ouvrage en retard";

    /**
     * Recuperer la liste des emprunts en retard
     * @return
     */
    public List<Emprunt> listEmpruntRetard() {

        List<Emprunt> vListEmprunt = port.getListEmprunt().getItem();

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
    public void envoiRetard() {

        List<Emprunt> vListEmprunt = listEmpruntRetard();

        for (int i = 0; i < vListEmprunt.size(); i++) {
            pUtilisateur = port.getUtilisateur(vListEmprunt.get(i).getIdUtilisateur());
            emailService.sendSimpleMessage(pUtilisateur.getMail(), sujet, textMessage);
        }
    }

}
