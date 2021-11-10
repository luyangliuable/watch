package edu.monash.fit2099.counters;

import edu.monash.fit2099.counters.Counter;

public class MaxCounter extends Counter {

	private int max;
	
	public MaxCounter(int max) {
		this.max = max;
	}
	
	@Override	
	public void increment() {
		super.increment();
		if (this.getValue() == max) {
			this.reset();
		}
	}

	public int getMax() {
		return max;
	}
}
