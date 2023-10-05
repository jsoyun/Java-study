package GodOfJava.src.main.java.java8.Chapter07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class sequentialSum {
    public static long sequentialSumMethod(long n){
       return  Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L , Long::sum);
    }
    public static long parallelSumMethod(long n){
        return  Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel() //스트림을 병렬로 처리 (스트림이 여러 청크로 분할되어 있어서 리듀싱 연산을 여러 청크에 병렬로 수행할 수 있다.)
                .reduce(0L , Long::sum); //마지막으로 리듀싱 연산으로 생성된 부분 결과를 다시 리듀싱 연산으로 합쳐서 전체 스트림의 리듀싱 결과를 도출한다.
    }

    public static long iterativeSum(long n){
        long result =0;
        for (long i = 1L ; i<= n; i++){
            result += i;
        }
        return result;
    }

    public long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
    public static long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator{
        public long total = 0;
        public void add(long value) {total += value ; };
    }
    public static void main(String[] args) {
      System.out.println("  sequentialSumMethod(3)"+   sequentialSumMethod(3));
      System.out.println("  iterativeSum"+   iterativeSum(3));
      System.out.println("sideEffectParallelSum:"+ sideEffectParallelSum(10_000_000L));


    }
}
