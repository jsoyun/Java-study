package chapter05;

public class MemberDTO {
	public String name;
	public String phone;
	public String email;

	public static void main(String[] args) {
		System.out.println("This is a static method.");
		
	}
	
	public MemberDTO(String name) {
		this.name = name;
	}
	public MemberDTO(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

}
