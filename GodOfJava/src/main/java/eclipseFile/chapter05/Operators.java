package chapter05;

public class Operators {
	
	public void additive() {
		int intValue1 = 5;
		int intValue2 = 10;
		
		int result = intValue1 + intValue2;
		System.out.println("result"+result);
		result = intValue2 -intValue1;
		System.out.println("result"+result);
		
		
		
	}
	
	public void multiple() {
		int intValue1 = 5;
		int intValue2 = 10;
		
		int result = intValue1 * intValue2;
		System.out.println("result"+result);
		float result2 = (float) intValue1/intValue2;
		System.out.println("result2"+result2);
		
		
		
	}
	
	public void reminder() {
		int intValue1 = 53;
		int intValue2 = 10;
		
		int result = intValue1 % intValue2;
		System.out.println("result"+result);
	
	
	}
	
	public void compound() {
		int intValue1 = 10;
		intValue1 += 5;
		System.out.println("intValue1:"+intValue1);
		intValue1 -= 5;
		System.out.println("intValue2:"+intValue1);
		intValue1 *= 5;
		System.out.println("intValue3:"+intValue1);
		intValue1 /= 5;
		System.out.println("intValue4:"+intValue1);
		intValue1 %= 5;
		System.out.println("intValue5:"+intValue1);
		
		
	}
	
	public void unary() {
		int intValue1 = -10;
		int result = +intValue1;
		System.out.println(result);
		result = -intValue1;
		System.out.println(result);
		
		
	}
	
	public void increDecre() {
		int intValue = 1;
		System.out.println(intValue++);
		System.out.println(intValue);
		System.out.println(++intValue);
		
	}
	
	public static void main(String[] args) {
		Operators sample = new Operators();
//		sample.additive();
//		sample.multiple();
//		sample.reminder();
//		sample.compound();
//		sample.unary();
//		sample.increDecre();
//		sample.comlement();
//		sample.comparison();
		sample.casting();
		
		
	}
	
	public void comlement() {
		boolean flag = true;
		System.out.println(flag);
		System.out.println(!flag);
	}
	
	public void comparison() {
		int intValue1 = 1;
		int intValue2 = 2;
		int intValue3 = 1;
		System.out.println(intValue1 == intValue2);
		System.out.println(intValue1 == intValue3);
		
		System.out.println(intValue1 != intValue2);
		System.out.println(intValue1 != intValue3);
		
		System.out.println("---");
		
		char charValue = 'a';
		System.out.println(97 == charValue);
		double doubleValue = 1.0;
		System.out.println(intValue1 == doubleValue);
		
	}
	
	public void casting() {
		byte byteValue = 127;
//		short shortValue = byteValue;
		short shortValue = 256;
		
		
//		shortValue++;
		System.out.println(shortValue);
		byteValue = (byte) shortValue;
		System.out.println(byteValue);
		
	}
	

}
