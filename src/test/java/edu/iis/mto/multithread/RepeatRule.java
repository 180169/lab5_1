/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;

/**
 *
 * @author Godzio
 */
public class RepeatRule implements TestRule {

    @Override
    public Statement apply( Statement statement, org.junit.runner.Description description ) {
        Statement result = statement;

        Repeat repeat = description.getAnnotation( Repeat.class );
        if ( repeat != null ) {
            int times = repeat.times();
            result = new RepeatStatement( times, statement );
        }
        return result;
    }

    @Retention( RetentionPolicy.RUNTIME )

    @Target( {
        java.lang.annotation.ElementType.METHOD

    } )

    public @interface Repeat {

        public abstract int times();

    }

    private static class RepeatStatement extends Statement {

        private final int times;

        private final Statement statement;

        private RepeatStatement( int times, Statement statement ) {
            this.times = times;

            this.statement = statement;

        }

        @Override

        public void evaluate() throws Throwable {

            for ( int i = 0; i < times; i++ ) {

                statement.evaluate();

            }

        }

    }

}