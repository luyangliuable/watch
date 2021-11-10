package edu.monash.fit2099.watches;

import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch3 extends Watch {

    private LinkedCounter milliseconds;
    private LinkedCounter seconds;
    private LinkedCounter minutes;
    private MaxCounter hours;

    public Watch3() {
        // Connnascence of position still remain. The first element of argument array must contain the lastCounter.
        // Need documentation to explain this.
        // Smart tho, using public static final int to refer to the literals
        super(new int[]{MAX_HOURS,MAX_MINUTES,MAX_SECONDS,MAX_MILLISECONDS});
    }
}
