package org.val.win.batch;

import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;
import org.val.win.util.ContextLoader;

import javax.inject.Named;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;


@Named
public class EmpruntService {

    P7Service port;

    public EmpruntService(){
        final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
        URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
        P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
        port = ss.getP7ServiceImplPort();

    }

    /**
     * Recuperer la liste des emprunts en retard
     * @return
     */
    public List<Emprunt> listEmpruntRetard() {

        List<Emprunt> vListEmprunt = port.getListEmprunt().getItem();

        List<Emprunt> vListEmpruntRetard = vListEmprunt.stream()
                .filter(p -> p.getDateFin().toGregorianCalendar()
                        .before(GregorianCalendar.getInstance()))
                .filter(p -> !p.getEtat().equals("Terminé"))
                .collect(Collectors.toList());

        for (Emprunt emprunt : vListEmpruntRetard) {
            port.retardEmprunt(emprunt);
        }
        return vListEmpruntRetard;
    }

    /**
     * Lister les ouvrages en retard
     * @return une liste d'ouvrage en retard
     */
    public List<String> listOuvrageRetard(Utilisateur pUtilisateur) {

        List<Emprunt> vListEmprunt = listEmpruntRetard();
        List<String> vListOuvrage = new ArrayList<>();

        for (int i = 0; i < vListEmprunt.size(); i++) {
            Ouvrage pOuvrage = port.getOuvrage(vListEmprunt.get(i).getIdOuvrage());
            for (Emprunt emprunt: vListEmprunt) {
                if (pUtilisateur.getIdUtilisateur().equals(emprunt.getIdUtilisateur())) {
                    vListOuvrage.add(pOuvrage.getNomOuvrage());
                }
            }
        }

        return vListOuvrage;
    }

    /**
     * Methode pour envoyer un emai en cas de retard
     *
     */
    public void envoiRetard() {

        List<Emprunt> vListEmprunt = listEmpruntRetard();
        List<Utilisateur> vListUtilisateur = new ArrayList<>();
        Utilisateur pUtilisateur;

        for (int i = 0; i < vListEmprunt.size(); i++) {
            pUtilisateur = port.getUtilisateur(vListEmprunt.get(i).getIdUtilisateur());
            List<String> vOuvrageRetard = listOuvrageRetard(pUtilisateur);
            if (!vListUtilisateur.contains(pUtilisateur)) {
                ContextLoader.INSTANCE.getEmailService().sendSimpleMessage(pUtilisateur.getMail(), vOuvrageRetard);
                vListUtilisateur.add(pUtilisateur);
            }
        }
    }

}
