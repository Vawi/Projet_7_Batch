package org.val.win;

import org.junit.Assert;
import org.junit.Test;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;


import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;


public class P7ServiceTest {

    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();


    @Test
    public void getListEmprunt() {
        List<Emprunt> listEmprunt = port.getListEmprunt().getItem();
        Assert.assertNotNull(listEmprunt);
    }

    @Test
    public void getOuvrage() {
        Ouvrage ouvrage = port.getOuvrage(1);
        String nomOuvrage = ouvrage.getNomOuvrage();
        System.out.println(nomOuvrage);
        Assert.assertNotNull(ouvrage);
    }

    @Test
    public void getUtilisateur() {
        Utilisateur utilisateur = port.getUtilisateur(2);
        System.out.println(utilisateur);
        Assert.assertNotNull(utilisateur);
    }

}
