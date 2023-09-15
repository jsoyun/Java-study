//package chapter15;
//
//import java.lang.reflect.Method;
//
//public class UserAnnotationSample {
//
////	@UserAnnotation(number = 0)
////	public static void main(String args[]) {
////		UserAnnotationSample sample = new UserAnnotationSample();
////
////	}
////
////	@UserAnnotation(number =1)
////	public void annotationSample1() {
////
////	}
////	@UserAnnotation(number =2)
////	public void annotationSample2() {
////
////	}
////	@UserAnnotation(number =3)
////	public void annotationSample3() {
////
////	}
//
//	public void checkAnnotations(Class useClass) {
//		Method[] methods = useClass.getDeclaredMethods();
//		for (Method tempMethod: methods) {
//			UserAnnotation annotation =
//					tempMethod.getAnnotation(UserAnnotation.class);
//			if (annotation != null) {
//				int number = annotation.number();
//				String text = annotation.text();
//				System.out.println
//			}
//		}
//
//
//	}
//
//}
