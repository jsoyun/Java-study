package GodOfJava.src.main.java.java8.Chapter06;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static GodOfJava.src.main.java.java8.Chapter06.Dish.PartitionPrimesWithCustomCollector;
import static java.util.stream.Collectors.partitioningBy;

public class CollectorHarness {

    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate); //소수의 대상을 주어진 수의 제곱근 이하의 수로 제한!
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i ==0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate))
                );
    }
    public static void main(String[] args) {
        long fastert = Long.MAX_VALUE;
        for ( int i = 0; i< 10; i++){
            long start = System.nanoTime();
//            partitionPrimes(1_000_000);
            PartitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if( duration < fastert) fastert = duration ; //가장 빨리 실행되었는지 확인

        }
        System.out.println(
                "Fastest execution done in " + fastert + " msecs"
        );
    }
}
