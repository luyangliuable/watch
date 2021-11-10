package edu.monash.fit2099.counters;

/**
 * A class containing all methods unique to counter
 *
 *
 * Single responsibility
 * Open close principle. Static polymorphism
 *
 */


public class Counter {

    private int value = 0;


	public void reset() {
		value = 0;
	}

	public void decrement() {
		value--;
	}

	public void increment() {
		value++;
	}

	public int getValue() {
		return value;
	}
}
