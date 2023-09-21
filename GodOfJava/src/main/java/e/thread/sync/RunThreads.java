package GodOfJava.src.main.java.e.thread.sync;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads runThreads = new RunThreads();
//        runThreads.checkThreadState1();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        runThreads.infinite();
        runThreads.checkThreadStack2();

    }

    public void checkThreadState1(){
        SleepThread thread = new SleepThread(2000);

        try {
            System.out.println("thread state="+ thread.getState());
            thread.start();
            System.out.println("thread state(after start)" + thread.getState());
            Thread.sleep(1000);


            System.out.println("thread state(after 1sec) = "+ thread.getState());
            thread.join(300); //수행중인 쓰레드가 중지할 때까지 대기한다.
            System.out.println("thread state(after 1sec) = "+ thread.getState());

            thread.interrupt(); //수행중인 쓰레드에 중지요청을 한다. //실행시 잠자던 쓰레드가 멈추고 InterruptedException 발생
            System.out.println("thread state(r join)=" + thread.getState());
           System.out.println( thread.isInterrupted());
//           System.out.println("현재 수행중인 쓰레드를 객체를 리턴한다."+Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void infinite(){
        InfiniteThread thread = new InfiniteThread();
        thread.start();

        try {

            Thread.sleep(500);
            thread.interrupt();
            System.out.println("interrupt() called");
            thread.join(500);
        } catch (InterruptedException e) {
            e.toString();
        }
        System.out.println("isAlive=" + thread.isAlive());
        System.out.println("isInterrupted =" + thread.isInterrupted());
    }

    public void checkThreadStack2(){
        Object monitor = new Object(); //객체 생성
        StateThread thread = new StateThread(monitor);
        //Object객체의 메소드 wait , notify, notifyAll...
        try {
            System.out.println("thread state = "+ thread.getState());
            thread.start();
            System.out.println("thread state(after start)="+ thread.getState());
            Thread.sleep(100);
            System.out.println("thread state(after 0.1 sec)=" + thread.getState());

            synchronized (monitor){
                monitor.notify();
            }

            Thread.sleep(100);
            System.out.println("thread state(after notify)=" + thread.getState());

            thread.join(); //스레드가 끝날 때까지 대기
            System.out.println("thread state(after join)="+ thread.getState());


        } catch (InterruptedException e) {
          e.printStackTrace();
        }

    }
}
