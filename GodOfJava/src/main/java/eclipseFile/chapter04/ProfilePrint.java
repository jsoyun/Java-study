package chapter04;

public class ProfilePrint {
	//인스턴스 변수 
//	클래스 안에 있는 변수 static없어야. 
	//클래스 변수 
	//인스턴스 변수와 같이 메소드 밖에 클래스 안에 선언된 변수중에 static 예약어 있는 변
	byte age =1;
	String name ="서";
	boolean isMarried = false;
	
	public void setAge(byte age) {
		this.age = age;
	}
	
	public byte getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public void setMarried(boolean flag) {
		this.isMarried = flag;
		
	}
	public boolean getMarried() {
		return isMarried;
	}
	
	public static void main(String [] args) {
		ProfilePrint  print = new ProfilePrint();
		byte age = 5;
		print.setAge(age);
		
		System.out.println(print.getAge());
		String name = "지성박 ";
		print.setName(name);
	
		System.out.println(	print.getName());
		boolean isMarried = true;
		print.setMarried(isMarried);
		System.out.println(	print.getName());

		
		
	}
	
}
