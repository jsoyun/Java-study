package chapter13;

public class NestedSample {

	public static void main(String[] args) {
		NestedSample sample = new NestedSample();
		sample.makeStaticNestedObject();
		sample.makeInnerObject();
		

		

	}
	
	public void makeStaticNestedObject() {
		OuterOfStatic.StaticNested staticNested = 
				new OuterOfStatic.StaticNested();
		staticNested.setValue(3);
		System.out.println(staticNested.getValue());
		
	}
	
	public void makeInnerObject() {
		OuterOfInner outer = new OuterOfInner();
		OuterOfInner.Inner inner = outer.new Inner();
		inner.setValue(22222);
		
		System.out.println(inner.getValue());
	}
	
	//내부클래스로 EventListener 인터페이스를 구현했음. 이걸 set 메소드의 매개변수로 씀 
	class MagicButtonListener implements EventListener{

		@Override
		public void onClick() {
			System.out.println("Magic Button Clicked!!!");
			
			
		}
		
		
	}
	public void setButtonListener() {
		MagicButton button = new MagicButton();
//		//내부 클래스의 객체 생성 
//		MagicButtonListener listener = new MagicButtonListener();
//		button.setListener(listener);
		
		//익명 클래스 
//		button.setListener( new EventListener() {
//			public void onClick() {
//				System.out.println("Magic Button Clicked! 익명클래스 ");
//			}
//		});
		
		// 객체를 해당 클래스 내에서 재사용하려면 이렇게 객체 생성하면 된다. 
		EventListener listener = new EventListener() {
			public void onClick() {
				System.out.println("Magic Button Clicked!!");
			}
			
		};
		button.setListener(listener);
		
		button.onClickProcess();
	}
	
	

}
