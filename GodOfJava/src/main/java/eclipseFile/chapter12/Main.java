package chapter12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverTimeManager manager = new OverTimeManager();
//		int myAmount = manager.getOverTimeAmount(OverTimeValues.THREE_HOUR);
//		System.out.println("myAmount"+myAmount);
		
		OverTimeValues2 value2 = OverTimeValues2.FIVE_HOUR;
		System.out.println(value2);
		System.out.println(value2.getAmount());


	}

}
