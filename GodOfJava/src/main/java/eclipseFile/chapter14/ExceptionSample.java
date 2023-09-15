package chapter14;

public class ExceptionSample {

	public static void main(String[] args)  {
		ExceptionSample sample = new ExceptionSample();
//		sample.arrayOutOfBounds();
//		sample.finallySample();
//		sample.multiCatch();
//		sample.throwable();
		try {
		sample.throwException2(13);
		
		} catch(Exception e) {
			System.out.println("e"+e.toString());
			
			
		}
	}
	
	public void arrayOutOfBounds() {
		int[] intArray = new int[5];
		try {
		
			System.out.println(intArray[5]);	
		
		} catch(Exception e) {
			System.out.println("error");
			System.out.println(intArray.length);
			
			
		}
		System.out.println("This code should run");
	}
	
	public void finallySample() {
		int[] intArray = new int[5];
		try {
			System.out.println(intArray[4]);
			
		} catch(Exception e){
			System.out.println(intArray.length);
			
			
		} finally {
			System.out.println("here is finally");
			
		}
		System.out.println("This code should run");
	}
	
	public void multiCatch() {
		int[] intArray = new int[5];
		try {
			intArray = null;
			System.out.println(intArray[5]);
			
		}
//		catch(NullPointerException e){
//			System.out.println("NullPointException occured");	
//		}  
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException occured");	
		} 
		
		catch(Exception e){
			System.out.println("Exception occured");	
		} 
	
	
	}
	
	public void throwable() {
		int [] intArray = new int[5];
		try {
//			intArray = null;
			System.out.println(intArray[5]);
		} catch(Throwable t) {
			System.out.println(t.toString());
			t.printStackTrace();
			
		}
		
	}
	
	public void throwException(int number) throws Exception {
		if(number >12) {
			throw new Exception("Number is over than 12");
		}
		
		
//		try {
//			
			if(number >12) {
				throw new Exception("Number is over than 12");
			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}
		
	}
	
	public void throwException2(int number) throws MyException {
		if(number >12) {
			throw new MyException("Number is over than 12dd");
		}
		
		
		try {
			
			if(number >12) {
				throw new MyException("Number is over than 12");
			}
			
		} catch(MyException e) {
			e.printStackTrace();
			
		}
		
	}

}
