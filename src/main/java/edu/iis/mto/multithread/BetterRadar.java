/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

/**
 *
 * @author Godzio
 */
public class BetterRadar {

    private PatriotBattery battery;
    private Executor executor;

    public BetterRadar( PatriotBattery missle ) {
        this.battery = missle;
    }

    public void setExecutor( Executor executor ) {
        this.executor = executor;
    }

    public void notice( Scud enemyMissle ) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {
            public void run() {
                for ( int i = 0; i < 1; i++ ) {
                    battery.launchPatriot();
                }
            }
        };
        executor.execute( launchPatriotTask );

    }
}
