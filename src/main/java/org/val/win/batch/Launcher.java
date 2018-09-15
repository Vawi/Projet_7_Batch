package org.val.win.batch;

import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * Classe qui permettra de faire tourner le batch toutes les 24h
 */
public class Launcher {

    @Inject
    EmpruntService empruntService;

    /**
     * ScheduledExecutorService pour creer l'objet qui lancera le batch
     */
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    /**
     * Methode de gestion des retards
     */
    public void retardEmprunt() {

        final Runnable retard = new Runnable() {
            public void run() {
                empruntService.envoiRetard();
            }
        };

        final ScheduledFuture<?> retardHandler =
                scheduler.scheduleAtFixedRate(retard, 0, 24, HOURS);

        scheduler.schedule(new Runnable() {
            public void run() { retardHandler.cancel(true); }
        }, 5, MINUTES);
    }
}
