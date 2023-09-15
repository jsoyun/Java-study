package chapter05;

public class Inheritance {
	
	public void objectCast2() {
		Parent[] parentArray = new Parent[3];
		parentArray[0] = new Child();
		parentArray[1] = new Parent();
		parentArray[2] = new Child();
		
		for (Parent tempParent : parentArray) {
			//검사는 자식부터!!!!
			if (tempParent instanceof Child) {
				System.out.println("Child");
				Child tempChild = (Child) tempParent;
				tempChild.printAge();
				
				
			} else if (tempParent instanceof Parent) {
				System.out.println("Parent");
				
			}
		}
	}
	
	public void objectCast() {
//		Parent parent = new Parent();
		Child child = new Child();
		
		Parent parent2 = child;
//		Child child2 = (Child)parent;
		Child child2 = (Child)parent2;
		
		
	}
	

	public static void main(String[] args) {
//		Child child = new Child();
//		child.printName();
//		Parent obj = new Child();
		Inheritance inheritance = new Inheritance();
		
		inheritance.objectCast2();

	}

}
