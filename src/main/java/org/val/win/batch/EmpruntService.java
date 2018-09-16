package org.val.win.batch;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.val.win.mail.contract.EmailService;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@PropertySource("classpath:configurationMail.properties")
@Named
public class EmpruntService {


    /**
     * Connection au webservice
     */
    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();

    @Inject
    private EmailService emailService;

    private Utilisateur pUtilisateur;

    @Value( "${mail.sujet}" )
    private String sujet;

    @Value( "${mail.text}" )
    private String textMessage;

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
     * Lister les ouvrages en retard
     * @return une liste d'ouvrage en retard
     */
    public List<Ouvrage> listOuvrageRetard() {

        List<Emprunt> vListEmprunt = listEmpruntRetard();
        List<Ouvrage> vListOuvrage = new ArrayList<Ouvrage>();

        for (int i = 0; i < vListEmprunt.size(); i++) {
            Ouvrage pOuvrage = port.getOuvrage(vListEmprunt.get(i).getIdOuvrage());
            vListOuvrage.add(pOuvrage);
        }

        return vListOuvrage;
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
