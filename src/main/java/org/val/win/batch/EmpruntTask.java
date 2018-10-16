package org.val.win.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.val.win.util.ContextLoader;


public class EmpruntTask implements Runnable{

    /*EmpruntService empruntService;

    public EmpruntTask(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        empruntService = (EmpruntService)context.getBean("empruntService");
    }*/

    @Override
    public void run() {
        ContextLoader.INSTANCE.getEmpruntService().envoiRetard();
        ContextLoader.INSTANCE.getEmpruntService().
    }
}