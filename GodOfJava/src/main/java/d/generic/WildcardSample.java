package GodOfJava.src.main.java.d.generic;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();
        sample.callBoundedWildMethod();
        sample.callGenericMethod();


    }
    public void callWildcardMethod(){
        WildcardGeneric<String> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard("A");
        wildcardMethod(wildcard);


    }
    //만약 WildcardGeneric 객체를 다른 타입으로 받으려면 어떻게 해야할까?
//    public void wildcardMethod(WildcardGeneric<String> c){
//        String value = c.getWildcard();
//        System.out.println(value);
//    }
    //선언을 ?(wildcard타입이라고 한다. )로 하면된다. -> ?는 메소드의 매개변수로만 사용하는 것이 좋다.
    public void wildcardMethod(WildcardGeneric<?> c){
        Object value = c.getWildcard(); //타입을 String에서 Object로 바꿔줬다.
        System.out.println(value);
    }
    public void callBoundedWildMethod(){
        WildcardGeneric<Car> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard(new Car("BMW"));
        wildcardMethod(wildcard);

        WildcardGeneric<Bus> wilcard2 = new WildcardGeneric<>();
        wilcard2.setWildcard(new Bus("Bongo"));
        wildcardMethod(wilcard2);
        boundWildcardMethod(wilcard2);




    }
    //? extends Car 은 제네릭타입으로 Car를 상속받은 모든 클래스를 사용할 수 있다는 의미이다.
    public void boundWildcardMethod (WildcardGeneric<? extends Car> c ){
        Car value = c.getWildcard();
        System.out.println(value);
    }

    //wildcard로 메소드를 선언해봤다. 문제는 이렇게 하면 선언된 객체에 값을 추가할 수 없다. 조회만 하게 된다.
    //그 대안
    public <T> void genericMethod(WildcardGeneric<T> c,T addValue){
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);


    }
    public void callGenericMethod(){
        WildcardGeneric<String> stringValue = new WildcardGeneric<>();
        genericMethod(stringValue ,"fd");
    }

}
