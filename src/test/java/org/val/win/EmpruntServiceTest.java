package org.val.win;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.xml.namespace.QName;
import java.net.URL;
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
}
