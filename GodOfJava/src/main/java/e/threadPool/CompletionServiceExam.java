package GodOfJava.src.main.java.e.threadPool;

import java.util.concurrent.*;

public class CompletionServiceExam {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        //CompletionSerive 생성
        CompletionService<Integer> completionService =
                new ExecutorCompletionService<>(executorService);

        System.out.println("처리 요청");
        for (int i=0; i<3; i++){
            completionService.submit(
                    new Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {
                           int sum =0;
                           for (int i=1; i<= 10; i++){
                               sum += i;
                           }
                           return sum;
                        }
                    }
            );
        }
        System.out.println("처리 완료된 작업 확인");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Future<Integer> future = completionService.take();
                        int value = future.get();
                        System.out.println("처리 결과:" + value);
                    } catch (Exception e) {
//                      e.printStackTrace();
                        e.toString();
                        System.out.println("여기같어"+ e.toString());
                        break;
                    }

                }
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            System.out.println("???");
        }

        executorService.shutdownNow();
    }
}
