package GodOfJava.src.main.java.e.thread.sync;

public class StateThread extends Thread{
    private Object monitor;
    public StateThread(Object monitor){
        this.monitor = monitor;  //Object 객체를 매개변수로 받아 인스턴스 변수로 선언
    }

    @Override
    public void run() {
        System.out.println("run 실행");
        //쓰레드를 실행중인 상태로 만들기 위해 루프 돌면서 String객체를 생성
            try {
                for(int loop =0; loop<1000; loop++){
                    String a = "A";
                    System.out.println("for문");
                }
                synchronized (monitor) {
                    monitor.wait();
                    System.out.println("synchronized");
                }
                System.out.println(getName()+" is notified.");
                Thread.sleep(1000); //wait상황 끝나면 1초간 대기 했다가 스레드 종료
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

    }
}
