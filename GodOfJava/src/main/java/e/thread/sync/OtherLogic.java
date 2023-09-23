package GodOfJava.src.main.java.e.thread.sync;

public class OtherLogic {
    public void printMyNumber() {
        System.out.println(Thread.currentThread().getName() +": OtherLogic value =" + ThreadLocalSample.get());
    }
}
