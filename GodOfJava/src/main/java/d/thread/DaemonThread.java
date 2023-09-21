package GodOfJava.src.main.java.d.thread;

public class DaemonThread extends Thread{

    public static void main(String[] args) {
        DaemonThread thread = new DaemonThread();
        thread.runDaemonThread();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    public void runDaemonThread(){
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }

}
