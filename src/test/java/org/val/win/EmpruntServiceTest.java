package org.val.win;

import org.junit.Assert;
import org.junit.Test;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;
import org.val.win.util.ContextLoader;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class EmpruntServiceTest {

    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();

    @Test
    public void listEmpruntRetard() {

        List<Emprunt> vListEmprunt = port.getListEmprunt().getItem();

        System.out.println(vListEmprunt);

        List<Emprunt> vListEmpruntRetard = vListEmprunt.stream()
                .filter(p -> p.getDateFin().toGregorianCalendar()
                        .before(GregorianCalendar.getInstance()))
                .collect(Collectors.toList());

        System.out.println(vListEmpruntRetard);

        Assert.assertNotNull(vListEmpruntRetard);

    }

    @Test
    public void envoiRetard() {

        List<Ouvrage> vlist = new ArrayList<>();

        String add = "valentin.winnen@orange.fr";

        ContextLoader.INSTANCE.getEmailService().sendSimpleMessage(add, vlist);

        Assert.assertNotNull(add);

    }
}
