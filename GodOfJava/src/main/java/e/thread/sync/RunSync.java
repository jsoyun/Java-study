package GodOfJava.src.main.java.e.thread.sync;

public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        runSync.runCommonCalculate();
    }

    private void runCommonCalculate() {
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountThread thread1
                = new ModifyAmountThread(calc, true);
        ModifyAmountThread thread2 = new ModifyAmountThread(calc,true);
        thread1.start();
        thread2.start();


        try{
            thread1.join(); //join 메소드는 쓰레드가 종료될때까지 기다리는 메소드이다.
            thread2.join();
            System.out.println("Final value is " + calc.getAmount());
        } catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
