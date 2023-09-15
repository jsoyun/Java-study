package GodOfJava.src.main.java.eclipseFile.chapter03;

public class Car {
	//기본 생성자 
	public Car(){
		
	}
	
	int speed;
	int distance;
	String color;
	
	//메소드 
	public void speedUp() {
//		this.speed += 5;
		speed += 5;
		
		
	}
	public void breakDown() {
		this.speed -= 10;
		
	}
	public int getCurrentSpeed() {
		return speed;
	}
	
	

}
