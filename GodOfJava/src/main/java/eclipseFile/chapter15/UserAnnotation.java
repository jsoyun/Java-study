package chapter15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //어노테이션 사용 대상을 지정한다. 이 어노테이션은 메소드에 사용할 수 있다고 지정되었다. 
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지 정보를 지정하는데 사용한다. 소괄호 안에 RetentionPolicy.RUNTIME으로 지정하면
									//실행시에 이 어노테이셔ㅕㄴ을 참조하게 된다. 
public @interface UserAnnotation{  // @interface 로 선언하면 @UserAnnotation 으로 사용가능한 어노테이션이 만들어진다. 
	public int number();
	public String text() default "This is first annotation";
	
}

