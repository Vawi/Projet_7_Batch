package org.val.win.batch;

import org.joda.time.LocalDate;
import org.val.win.mail.contract.EmailService;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;

import javax.inject.Inject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Batch qui servira a envoyer des emails
 */
public class BatchConfiguration {


    @Inject
    private P7Service p7Service;

    @Inject
    private EmailService emailService;

    private Utilisateur pUtilisateur;

    /**
     * Charge les propriétés du fichier texte
     */
    private String[] properties = readFile();
    
    private String sujet = properties[0];
    private String textMessage = properties[1];

    /**
     * Methode qui lira les informations d'un fichier txt
     * @return les info contenu dans le fichier txt
     */
    public String[] readFile()
    {

        String[] values = new String[2];
        try {

            Properties properties = new Properties();
            String path = System.getProperty("user.dir") + File.separator + "/src/resources/configMail.txt";
            FileInputStream file = new FileInputStream(path);
            properties.load(file);

            values[0] = properties.getProperty("sujet");
            values[1] = properties.getProperty("text");

        } catch (FileNotFoundException e)
        {
            System.out.println("Le fichier n'a pas \u00e9t\u00e9 trouv\u00e9");
        } catch (IOException e)
        {
            System.out.println("Le fichier n'a pas pu être charg\u00e9");
        }

        return values;
    }

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
