package org.val.win.batch;

import org.val.win.util.ContextLoader;


public class EmpruntTask implements Runnable{

    @Override
    public void run() {
        ContextLoader.INSTANCE.getEmpruntService().envoiRetard();
    }
}