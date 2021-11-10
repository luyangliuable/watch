package edu.monash.fit2099.watches;

import edu.monash.fit2099.counters.Counter;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

import java.util.ArrayList;

/**
 * Single responsibility class for watch. Open to extension
 */
public abstract class Watch {

    ///////////////////////////////////////////////////////////////////////////
    //   static final class field variables to store literals to ReD         //
    ///////////////////////////////////////////////////////////////////////////

    // Static final variables are used to avoid literals
    // DOn't need to be private because they are fixed
    public static final int MAX_HOURS=24;
    public static final int MAX_MINUTES=60;
    public static final int MAX_SECONDS=60;
    public static final int MAX_MILLISECONDS=1000;

    private ArrayList<MaxCounter> counters = new ArrayList<>();


    // Constructor when no parameter is provided
    public Watch() {
        counters = new ArrayList<>();
    }

    // Constructor when parameters are provided
    public Watch(int[] maxValues) {

        // Connascenence of position between classes
        // A solution could be a if statement that only accepts max hour, turning into a weaker connnascence of name
        MaxCounter lastCounter = new MaxCounter(maxValues[0]);
        addCounter(lastCounter);

        for (int i = 1; i < maxValues.length; i++) {
            MaxCounter aCounter = new LinkedCounter(maxValues[i], lastCounter);
            addCounter(aCounter);
            lastCounter = aCounter;
        }

    }

    // Command-Query Separation Principle
    public void addCounter(MaxCounter aCounter) {
        // command
        counters.add(aCounter);
    }

    MaxCounter getLastCounter(){
        // query
        return counters.get(counters.size()-1);
    }

    public void tick(){
        // command
        getLastCounter().increment();
    };

    //    public abstract void display();

    public void testWatch(int numTicks) {
        // command and query?
        for (int i = 0; i < numTicks; i++) {
            display();
            tick();
        }
    }

    public void display() {
        String prefix="";
        for (MaxCounter aCounter : counters) {
            // encapsulated within the method scope
            double fSize = Math.ceil(Math.log10(aCounter.getMax()));//2.0  3.0

            String fFormat = "%0" + String.format("%.0f", fSize) + "d";

            System.out.print(prefix + String.format(fFormat, aCounter.getValue()));

            prefix = ":";
        }
        // commmand
        System.out.println();
    }
}
