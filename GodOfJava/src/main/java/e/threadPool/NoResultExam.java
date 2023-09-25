package GodOfJava.src.main.java.e.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExam {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        //사용 가능한 프로세서(코어)의 수를 반환하는 메소드

        System.out.println("[작업처리 요청]");

        Runnable run = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i =1; i<=10; i++){
                    sum += i;
                }
                System.out.println("[처리 결과] :" + sum);

            }

        };
        Future future = executorService.submit(run);
        try {
            future.get(); //결과를 받는다.
            System.out.println("[작업 처리 완료]");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();


    }
}
