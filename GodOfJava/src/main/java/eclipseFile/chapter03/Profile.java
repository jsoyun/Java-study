package chapter03;

public class Profile {
	String name;
	int age;
	
	public void setName(String str) {
		this.name = str;

		
	}
	public void setAge(int val) {
		age = val;
	}
	
	public void printName(String name) {
        System.out.println("Local variable name: " + name);
        System.out.println("Member variable name: " + this.name); // this 키워드 사용
    }
//	public void printName() {
//		System.out.println(name);
//		
//	}
//	public void printAge() {
//		System.out.println(age);
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		String name = "Min";
		int age = 27;
		profile.setName(name);
//		profile.setAge(age);
//		profile.printName();
//		profile.printAge();
		profile.printName("?????");
		
		

	}

}
