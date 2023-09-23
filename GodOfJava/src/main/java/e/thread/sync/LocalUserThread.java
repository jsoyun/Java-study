package GodOfJava.src.main.java.e.thread.sync;

public class LocalUserThread extends Thread{
    @Override
    public void run() {
        int value = ThreadLocalSample.generateNumber();
        System.out.println(this.getName()+": LocalUserThread value="+value);

        OtherLogic otherLogic = new OtherLogic();
        otherLogic.printMyNumber();
        ThreadLocalSample.remove(); //값을 지운다.
    }
}
