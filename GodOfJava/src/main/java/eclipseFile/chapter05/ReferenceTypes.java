package chapter05;

public class ReferenceTypes {
//	public void checkMemberDTOName() {
//		MemberDTO dto1= new MemberDTO("Sangmin");
//		System.out.println(dto1.name);
//		MemberDTO dto2 = new MemberDTO("Sungchoon");
//		System.out.println(dto1.name);
//		
//	}
	
	public void callPassByValue() {
		int a = 10;
		String b = "b";
		MemberDTO member= new MemberDTO("Sangmin");
		passByValue(a,b,member);
		System.out.println("callPassByValue method result !!!");
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("member.name="+member.name);
}
	//값을 전달한다. 
	public void passByValue(int a, String b, MemberDTO member) { //기본자료형은 무조건 passbyvalue 값을 복사해 전달, 참조자료형은 객체 주소를 전달해서 변결
		a= 20;
		b = "z";
//		member = new MemberDTO("SungChoon"); //새로운 객체를 만들어서 값을 할당
		member.name = "SungChoon"; // 기존 객체의 name을 바
		System.out.println("passByValue method result!!!");
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("member.name="+member.name);
	}
	
	//
	public void calculateNumbers(String message, int... numbers) {
		
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		System.out.println("Total="+ total);
	}
	public static void main(String[] args) {
		ReferenceTypes reference = new ReferenceTypes();
//		reference.checkMemberDTOName();
		
//		System.out.println("data="+StaticBlock.getData());
//		System.out.println("Creating block1");
//		StaticBlock block1 = new StaticBlock();
//		System.out.println("Created block1");
//		
//		System.out.println("Creating block2");
//		StaticBlock block2 = new StaticBlock();
//		System.out.println("Created block2");
//		System.out.println("data="+StaticBlock.getData());
		
		reference.callPassByValue();
		
		MemberDTO dto = new MemberDTO("Sangmin","010101","god@dfs.com");
		System.out.printf("Name:%s Phone:%s E-Mail:%s\n", dto.name, dto.phone,dto.email);
		
		
		
	}

}
