package GodOfJava.src.main.java.e.thread.sync;

public class CommonCalculate {
    private int amount;
    private  Object amountLock = new Object();
    public CommonCalculate(){
        amount = 0;
    }

    public  void plus(int value){
        synchronized (amountLock){
            amount += value;

        }

    }
    public synchronized void minus (int value){
        amount -= value;
    }
    public int getAmount(){
        return amount;
    }
}
