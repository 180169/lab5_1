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
public class MyExecutor implements Executor{

    @Override
    public void execute( Runnable command ) {
        command.run();
    }
    
}
