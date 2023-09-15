package chapter01;


public class Calculator {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.substract(5, 4);
		cal.multiple(5, 4);
		cal.divide(5, 4);
		
		System.out.println("1:" +	cal.substract(5, 4));
		System.out.println("2:" +	cal.multiple(5, 4));
		System.out.println("3:" +	cal.divide(5, 4));
		
		
		
		

	}
	
	public int substract(int num1, int num2) {
		return  num1 - num2 ;

		
	}
	public int multiple(int num1, int num2) {
		return  num1 * num2 ;

		
	}
	public int divide(int num1, int num2) {
		return  num1 / num2 ;

		
	}
	
	

}
