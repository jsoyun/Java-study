package GodOfJava.src.main.java.java8.Chapter07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long>{
    //더할 숫자 배열
    private final long[] numbers;
    private final int start;
    private final int end;

    //이 값 이하의 서브태스크는 더 이상 분할할 수 없다.
    public static final long THRESHOLD = 10_000;

    //메인 태스크를 생성할 때 사용할 공개 생성자
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
//        numbers = new long[0];
//        start = 0;
//        end = 0;
    }
    //메인 태스크의 서브 태스크를 재귀적으로 만들 때 사용할 비공개 생성자
    private ForkJoinSumCalculator(long[] numbers, int start , int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() { //RecursiveTask의 추상 메서드 오버라이드

        int length= end - start; //이 태스크에서 더할 배열의 길이
        if (length <= THRESHOLD){
            return computeSequentially(); //기준값과 같거나 작으면 순차적으로 결과를 계산한다.
        }
        //배열의 첫 번째 절반을 더하도록 서브태스크를 생성한다.
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        //ForkJoinPool의 다른 스레드로 새로 생성한 태스크를 비동기로 실행한다.
        leftTask.fork();

        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers,start + length/2, end);
        //두번째 서브태스크를 동기 실행한다. 이때 추가로 분할이 일어날 수 있다.
        Long rightResult = rightTask.compute();
        //첫 번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다린다.
        Long leftResult = leftTask.join();
        //두 서브태스크의 결과를 조합한 값이 이 태스크의 결과다.
        return leftResult + rightResult;

    }
    //더 분할할 수 없을 때 서브태스크의 결과를 계산하는 단순한 알거리즘

    private long computeSequentially(){
        long sum = 0;
        for (int i= start; i< end; i++){
            sum += numbers[i];
        }
        return sum;

    }

  public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
      ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
      System.out.println("task"+task);
      return new ForkJoinPool().invoke(task);
      }

    public static void main(String[] args) {
        forkJoinSum(100);

    }



}
