package org.val.win.batch;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Classe qui permettra de faire tourner le batch toutes les 24h
 */
public class Launcher {

    public static void main(String[] args) {

        final ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        final ScheduledFuture<?> retardHandler =
                scheduler.scheduleAtFixedRate(new EmpruntTask(), 0, 30, SECONDS);
    }
}
