package org.val.win.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmpruntTask implements Runnable{

    EmpruntService empruntService;

    public EmpruntTask(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        empruntService = (EmpruntService)context.getBean("empruntService");
    }

    @Override
    public void run() {
        empruntService.envoiRetard();
    }
}