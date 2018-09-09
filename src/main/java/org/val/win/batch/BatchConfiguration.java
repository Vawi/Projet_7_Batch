package org.val.win.batch;

import org.val.win.mail.contract.EmailService;
import org.val.win.model.bean.Emprunt;
import org.val.win.service.P7Service;

import javax.inject.Inject;
import java.util.List;

public class BatchConfiguration {


    @Inject
    private P7Service p7Service;

    @Inject
    private EmailService emailService;

    public List<Emprunt> EmpruntRetard() {
        List<Emprunt> vListEmprunt = p7Service.getListEmprunt().getItem();
        List<Emprunt> vListRetard = vListEmprunt;

        return vListRetard;
    }


}
