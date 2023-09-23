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
//        runThreads.checkThreadStack2();
//        runThreads.checkThreadStack3();

//        runThreads.groupThread();
//        runThreads.runLocalUserThread();
        runThreads.runVolatileSample();
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


    public void checkThreadStack3(){
        Object monitor = new Object(); //객체 생성
        StateThread thread = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);

        //Object객체의 메소드 wait , notify, notifyAll...
        try {
            System.out.println("thread state = "+ thread.getState());
            thread.start();
            thread2.start();
            System.out.println("thread state(after start)="+ thread.getState());
            System.out.println("thread2 state(after start)="+ thread2.getState());
            Thread.sleep(100);
            System.out.println("thread state(after 0.1 sec)=" + thread.getState());
            System.out.println("thread2 state(after 0.1 sec)=" + thread2.getState());

//            synchronized (monitor){
////                monitor.notify();
//                monitor.notifyAll();
//            }

            Thread.sleep(100);
            System.out.println("thread state(after notify)=" + thread.getState());
            System.out.println("thread2 state(after notify)=" + thread2.getState());

            thread.join(); //스레드가 끝날 때까지 대기

            System.out.println("thread state(after join)="+ thread.getState());
            thread2.join(); //스레드가 끝날 때까지 대기
            System.out.println("thread2 state(after join)="+ thread2.getState());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void groupThread(){
        try {
            SleepThread sleepThread1 = new SleepThread(5000);
            SleepThread sleepThread2 = new SleepThread(5000);


            ThreadGroup group = new ThreadGroup("Group1");
            Thread thread1 = new Thread(group,sleepThread1);
            Thread thread2 = new Thread(group, sleepThread2);

            thread1.start();
            thread2.start();
            Thread.sleep(1000);
            System.out.println("Group name="+ group.getName());
            int activeCount = group.activeCount();
            System.out.println("Active count="+ activeCount);
            group.list(); //list메소드를 호출했을 때 결과이다.

            Thread[] tempThreadList = new Thread[activeCount];
            int result = group.enumerate(tempThreadList);
            System.out.println("Enumerate result=" + result);
            for (Thread thread: tempThreadList){
                System.out.println("thread[]입니다:"+thread);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void runLocalUserThread(){
        LocalUserThread threads[] = new LocalUserThread[3];
        for (LocalUserThread thread : threads){
            thread = new LocalUserThread(); //3개의 쓰레드 객체 생성
            thread.start();
        }
    }

    public void runVolatileSample(){
        VolatileSample sample = new VolatileSample();
        sample.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleep ended !!!");
        sample.setDouble(-1);
        System.out.println("Set value is completed!!!");

    }
}
