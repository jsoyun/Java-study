package GodOfJava.src.main.java.e.thread.sync;

import java.util.Random;
public class ThreadLocalSample {

    //ThreadLocal은 제네릭하게 되어있는 클래스이다.
    //이 클래스의 객체를 생성하기 위해서는 각 쓰레드에서 고유하게 사용할 데이터 타입을 지정해줘야한다.
    private final static ThreadLocal<Integer> local
            = new ThreadLocal<>();

    private static Random random;

    static {
        random = new Random();
    }

    public static Integer generateNumber(){
        int value = random.nextInt(45);
        local.set(value); //저장하고자하는 값 할당한다.
        return value;
    }

    public static Integer get(){
        System.out.println("ThreadLocalSample-get함수호출예아");
        return local.get(); //
    }

    public static void remove(){
        local.remove();
    }


}
