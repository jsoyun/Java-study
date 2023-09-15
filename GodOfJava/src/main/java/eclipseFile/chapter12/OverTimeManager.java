package chapter12;

public class OverTimeManager {
	public int getOverTimeAmount (OverTimeValues value) {
		int amount =0;
		System.out.println(value);
		switch (value) {
		case THREE_HOUR:
			amount = 18000;
			break;
		default: amount = 0;	
		
		}
		return amount;
		
		
	} 

}
