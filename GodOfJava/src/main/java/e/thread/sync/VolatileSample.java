package GodOfJava.src.main.java.e.thread.sync;

public class VolatileSample extends Thread{
    private double instanceVariable = 0;
//private volatile double instanceVariable = 0;
    void setDouble(double value){
        this.instanceVariable = value;
    }

    @Override
    public void run() {
      while (instanceVariable ==0){

          try {
              System.out.println( "VolatileSample run:"+instanceVariable);
              Thread.sleep(1);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
        System.out.println( "VolatileSample run:"+instanceVariable);
    }
}
