package org.val.win.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.val.win.util.ContextLoader;


public class EmpruntTask implements Runnable{

    public static final Logger logger = LogManager.getLogger(EmpruntTask.class);

    @Override
    public void run() {
        ContextLoader.INSTANCE.getEmpruntService().envoiRetard();

        logger.info("Methode run initialisée");
    }
}