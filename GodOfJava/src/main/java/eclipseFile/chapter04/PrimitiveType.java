package chapter04;

public class PrimitiveType {
	//클래스 변수 
	int intDefault1;
	byte byteDefault;
	short shortDefault;
	long longDefault;
	float floatDefault;
	double doubleDefault;
	char charDefault;
	boolean booleanDefault;
	
	
	public void defaultValues() {
		//지역변수 
		int intDefault2;
//		System.out.println(intDefault1);
//		System.out.println(intDefault2);
		System.out.println("byteDefault:"+byteDefault);
		System.out.println("shortDefault:"+shortDefault);
		System.out.println("longDefault:"+longDefault);
		System.out.println("floatDefault:"+floatDefault);
		System.out.println("doubleDefault:"+doubleDefault);
		System.out.println("charDefault:"+charDefault);
		System.out.println("booleanDefault:"+booleanDefault);
	}
	public static void main(String [] args) {
		PrimitiveType Types= new PrimitiveType();
		Types.defaultValues();
	
		
		
	}
	

//	public static void main(String[] args) {
//		PrimitiveType types = new PrimitiveType();
////		types.checkByte();
////		types.checkOtherTypes();
//		types.checkChar();
//		types.checkBoolean();
//		
//
//	}
//	public void checkByte() {
//		byte byteMin = -128;
//		byte byteMax = 127;
//		System.out.println("byteMin"+byteMin);
//		System.out.println("byteMax"+byteMax);
//		byteMin--;
//		byteMax++;
//		System.out.println("byteMin"+byteMin);
//		System.out.println("byteMax"+byteMax);
//		byteMin++;
//		
//		System.out.println("byteMin"+byteMin);
//	}
//	
//	public void checkOtherTypes() {
//		short shortMax = 32767;
//		int intMax = 2147483647;
//		long longMax = 9223372036854775807L;
//		System.out.println(shortMax);
//		System.out.println(intMax);
//		System.out.println(longMax);
//		
//	}
//	
//	public void checkChar() {
//		char charMin = '\u0000';
//		char charMax = '\uffff';
//		System.out.println("["+charMin+"]");
//		System.out.println("["+charMax+"]");
//		int intValue = 'a';
//		System.out.println("["+intValue+"]");
//		
//		
//	}
//	public void checkBoolean() {
//		boolean flag = true;
//		System.out.println(flag);
//		flag = false;
//		System.out.println(flag);
//		
//	}

}
