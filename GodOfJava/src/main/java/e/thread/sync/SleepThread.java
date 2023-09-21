package GodOfJava.src.main.java.e.thread.sync;

public class SleepThread extends Thread{
    long sleepTime;

    public SleepThread(long sleepTime){
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("run실행합니다");

        try {
            System.out.println("Sleeping " + getName());
            SleepThread.sleep(sleepTime); //? Thread는 객체 생성 없이 가져올 수 있어? 지금 스레드가 몇개지?
//            SleepThread.sleep(sleepTime); 이렇게 해도 같은 결과가 나오는거같은데?
            System.out.println("Sleeping Stopping" + getName());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
