package edu.monash.fit2099.watches;

import edu.monash.fit2099.counters.Counter;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

import java.util.ArrayList;

public abstract class Watch {

    public static final int MAX_HOURS=24;
    public static final int MAX_MINUTES=60;
    public static final int MAX_SECONDS=60;
    public static final int MAX_MILLISECONDS=1000;

    private ArrayList<MaxCounter> counters=new ArrayList<>();

    public Watch() {
        counters = new ArrayList<>();
    }

    public Watch(int [] maxValues){

        MaxCounter lastCounter=new MaxCounter(maxValues[0]);
        addCounter(lastCounter);
        for(int i=1;i<maxValues.length;i++){
            MaxCounter aCounter=new LinkedCounter(maxValues[i],lastCounter);
            addCounter(aCounter);
            lastCounter=aCounter;
        }

    }

    public void addCounter(MaxCounter aCounter) {
        counters.add(aCounter);
    }

    MaxCounter getLastCounter(){
        return counters.get(counters.size()-1);
    }

    public void tick(){
        getLastCounter().increment();
    };

//    public abstract void display();

    public void testWatch(int numTicks) {
        for (int i = 0; i < numTicks; i++) {
            display();
            tick();
        }
    }

    public void display() {
        String prefix="";
        for (MaxCounter aCounter : counters) {
            double fSize=Math.ceil(Math.log10(aCounter.getMax()));//2.0  3.0
            String fFormat="%0"+String.format("%.0f",fSize)+"d";
            System.out.print(prefix+String.format(fFormat, aCounter.getValue()));
            prefix=":";
        }
        System.out.println();
    }
}
