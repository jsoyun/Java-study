package GodOfJava.src.main.java.java8.Chapter07;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        String sentence = "단순한      문자열의 단어 수를 계산하는 메서드를 구현해보자.";

        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(sentence);

        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator,true).parallel();
        int wordCount = stream.reduce(
                new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine
        ).getCounter();
// 결과 출력
        System.out.println("wordCount: " + wordCount);
    }
}
