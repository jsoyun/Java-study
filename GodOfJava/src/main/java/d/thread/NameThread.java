package GodOfJava.src.main.java.d.thread;

public class NameThread extends Thread{
    private int calcNumber;
    public NameThread(String name , int calcNumber){
        super(name);
        this.calcNumber = calcNumber;

    }
    @Override
    public void run(){
        calcNumber++;

    }
}
