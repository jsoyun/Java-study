package GodOfJava.src.main.java.e.thread.sync;

public class TestSample {
    public static void main(String[] args) {
        Test testThread1 = new Test("Thread1");
        Test testThread2 = new Test("Thread2");
        Test testThread3 = new Test("Thread3");
        Test2 otherThread = new Test2();
        //3,2,1순으로 실행됨
//        testThread1.setPriority(1);
//        testThread1.start();
//        testThread2.setPriority(5);
//        testThread2.start();
//        testThread3.setPriority(10);
//        testThread3.start();

//        testThread1.setPriority(1);

//        testThread2.setPriority(5);
        otherThread.start();
        testThread1.start();

        testThread2.start();

//        testThread3.setPriority(10);
//        testThread3.start();

        try {

            Thread.sleep(1000);
            testThread1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        testThread3.yield();

        //run으로 하면 바로 실행됨 우선순위 상관없이 1,2,3
//        testThread1.setPriority(1);
//        testThread1.run();
//        testThread2.setPriority(5);
//        testThread2.run();
//        testThread3.setPriority(10);
//        testThread3.run();

    }
}

class Test2 extends Thread{



    @Override
    public void run() {
        for(int i = 0; i< 100; i++){
            i++;
            System.out.println("other Test~~~~~~~~~~`");
//            Thread.yield();


        }
//      while (true){
//          System.out.println("Test2");
//          Thread.yield();
//      }


    }
}
