package GodOfJava.src.main.java.d.thread;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
//        threads.runBasic2();
        threads.checkThreadProperty();
    }

//    public void runBasic(){
//        RunnableSample runnableSample = new RunnableSample();
//        ThreadSample threadSample = new ThreadSample();
//    // 여기서 주의 ! run메소드를 시작점으로 작성해야만 한다.
//        //그런데 쓰레드를 시작하는 메소드는 run이 아닌 start 메소드이다.
//        //이처럼 start메소드를 만들지 않아도 자바에서 run메소드를 수행하도록 되어있다.
//        new Thread(runnableSample).start(); //Runnable 실행방법
//        threadSample.start(); //thread 실행방법
//        System.out.println("RunfThreads.runBasic() method is ended.");
//
//    }

    public void runBasic2(){

        RunnableSample []runnableSample = new RunnableSample[5];
        ThreadSample []threadSample = new ThreadSample[5];

        for (int loop=0; loop<5 ; loop++){
            runnableSample[loop] = new RunnableSample();
            threadSample[loop] = new ThreadSample();

            new Thread(runnableSample[loop]).start();
            threadSample[loop].start();
        }
        System.out.println("RunThreads.runBasic2() method is ended");

    }

    public void checkThreadProperty(){
        ThreadSample thread1 = new ThreadSample();
        ThreadSample thread2 = new ThreadSample();
        ThreadSample daemonThread = new ThreadSample();

        System.out.println("thread1 id="+ thread1.getId());
        System.out.println("thread2 id="+ thread2.getId());

        System.out.println("thread1 id="+ thread1.getName());
        System.out.println("thread2 id="+ thread2.getName());

        System.out.println("thread1 prioity="+ thread1.getPriority());
        daemonThread.setDaemon(true);
        System.out.println("thread1 isDaemon="+ thread1.isDaemon());
        System.out.println("thread2 isDaemon="+ thread2.isDaemon());
        System.out.println("daemonThread isDaemon="+ daemonThread.isDaemon());


    }
}
