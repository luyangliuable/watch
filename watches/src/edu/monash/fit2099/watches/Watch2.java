package edu.monash.fit2099.watches;

import edu.monash.fit2099.counters.MaxCounter;

public class Watch2 extends Watch {


    private MaxCounter minutes;
    private MaxCounter hours;

    public Watch2() {
        super(new int[]{MAX_HOURS,MAX_MINUTES});
    }

}
