package edu.monash.fit2099.watches;

//https://maps.google.com/api/v2/
public class Watch1 extends Watch {// v1

//	private Counter minutes;
//	private Counter hours;
	private Watch2 myWatch2;  //v2

	public Watch1() {
		myWatch2=new Watch2();

/*		hours = new Counter();
		addCounter(hours);
		minutes = new Counter();
		addCounter(minutes);*/
	}

	public void tick() {
		myWatch2.tick(); // delegation
//		minutes.increment();
//		if (minutes.getValue() == MAX_MINUTES) {
//			minutes.reset();
//			hours.increment();
//			if (hours.getValue() == MAX_HOURS) {
//				hours.reset();
//			}
//		}
	}

	@Override
	public void display() {
		myWatch2.display();// delegate
	}
}
