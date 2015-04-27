/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;

/**
 *
 * @author Godzio
 */
public class BetterRadar {

    private PatriotBattery battery;

    public BetterRadar( PatriotBattery missle ) {
        this.battery = missle;
    }

    public void notice( Scud enemyMissle ) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {
            public void run() {
                for ( int i = 0; i < 10; i++ ) {
                    battery.launchPatriot();
                }
            }
        };

        Thread launchingThread = new Thread( launchPatriotTask );
        launchingThread.start();
    }
}
