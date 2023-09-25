package GodOfJava.src.main.java.e.threadPool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecuteExam {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0; i<10; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //이렇게 형변환 하는 이유가 뭐지????
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("총 스레드 개수" + poolSize +"작업스레드 이름" + threadName);

                    int value = Integer.parseInt("숫자"); //여기서 예외발생



                }
            };
//            executorService.execute(runnable); //작업처리 중 예외발생하면 스레드 종료되고 해당 스레드는 스레드풀에서 제거되고 스레드풀은 다른 작업처리를 위해 새로운 스레드를 생성한다.
            executorService.submit(runnable); //작업처리 중 예외발생하면 스레드는 종료되지 않고 다음 작업을 위해 재사용된다.

            //그렇다면 둘 중 무엇을 더 선호할까? 재사용하면 submit이 더 좋은거 아닌가?
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();

    }
}
