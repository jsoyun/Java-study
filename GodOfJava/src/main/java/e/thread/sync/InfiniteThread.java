package GodOfJava.src.main.java.e.thread.sync;

import java.util.HashMap;
import java.util.Hashtable;

public class InfiniteThread extends Thread{
    @Override
    public void run() {
        //무한루프, 문자열과 hashmap, hashtable 객체를 무한 생성하는 코드.
        while (true){
            String str = "String";
            new HashMap(10000);
            new Hashtable(10000);

            //
            if (Thread.interrupted())return ; // interrupted 현재 쓰레드가 중지되었는지 확인한ㄷ.


        }

    }
}
