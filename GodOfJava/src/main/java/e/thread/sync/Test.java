package GodOfJava.src.main.java.e.thread.sync;

public class Test extends Thread{
    private String threadName;

    public Test(String threadName){
        this.threadName = threadName;

    }
    @Override
    public void run() {

        for(int i = 0; i< 1000; i++){
            i++;
            System.out.println(i);
        }
//
//        while (true){
////            Thread.yield();
//            System.out.println("thread::"+threadName);
//
//        }
        System.out.println("thread::"+threadName);

//        System.out.println("run 실행됨");







    }
}
