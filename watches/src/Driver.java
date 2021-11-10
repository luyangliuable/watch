import edu.monash.fit2099.watches.Watch;
import edu.monash.fit2099.watches.Watch1;
import edu.monash.fit2099.watches.Watch2;
import edu.monash.fit2099.watches.Watch3;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		final  int NUM_TICKS=200;
		//Watch[] watches=new Watch[3];
		ArrayList<Watch> watches=new ArrayList<>();


//		watches[0] = new Watch1();
//		watches[1] = new Watch2();
//		watches[2] = new Watch3();

		watches.add(new Watch1());
		watches.add(new Watch2());
		watches.add(new Watch3());


//		for(int i=0;i<watches.length;i++){
//			watches[i].testWatch(NUM_TICKS);
//			System.out.println("--------------");
//		}

//		for(int i=0;i<watches.size();i++){
//			watches.get(i).testWatch(NUM_TICKS);
//			System.out.println("--------------");
//		}


		for(Watch watch:watches){
			System.out.println("Testing: "+watch.getClass().getSimpleName());
			watch.testWatch(NUM_TICKS);
		}




	}

}
