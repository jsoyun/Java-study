package GodOfJava.src.main.java.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import static java.util.Comparator.comparing;

public class practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> Transactionlist = transactions.stream()
                .filter( v->v.getYear() == 2011  )
//                .sorted()
                .sorted(comparing(Transaction::getValue)) //static 메서드 comparing
                .collect(toList()); //static 메서드 toList()
//        System.out.println("Transactionlist"+Transactionlist);

        List<String> citiesList = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

//        System.out.println("citiesList"+citiesList);

        //distinct()대신에 스트림을 집합으로 변환하는 toSet() 을 사용할 수 있다.
        Set<String> citiesListUsingSet = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
//        System.out.println("citiesListUsingSet"+citiesListUsingSet);

        //이것도 되긴함.
//        List<String> traderList1 = transactions.stream()
//                .filter(v->v.getTrader().getCity() =="Cambridge")
//                .map(v->v.getTrader().getName())
//                .distinct()
//                .sorted()
//                .collect(toList());
//        System.out.println("traderList1"+traderList1);

        List<Trader> traderList2 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct() //중복없애기
                .sorted(comparing(Trader::getName)) //스트림 거래자 이름으로 정렬
                .collect(toList());
//        System.out.println("traderLis2t"+traderList2);


//        되긴함
//        List<String> traderNameList = transactions.stream()
//                .map(v-> v.getTrader().getName())
//                .distinct()
//                .sorted()
//                .collect(toList());
//        System.out.println("traderNameList"+traderNameList);

        String traderNameList = transactions.stream()
                .map(v-> v.getTrader().getName())
                .distinct()
                .sorted() //중복된 이름 제거
                .reduce("",(n1, n2) -> n1+ " " +n2); //이름을 알파벳순으로 정렬
//        System.out.println("traderNameList "+traderNameList);

        //밀라노에 거래자가 있는가? Boolean

      boolean checkTraderInMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
//      System.out.println("checkTraderInMilan>>"+checkTraderInMilan);

      //6번
//        transactions.stream()
//                .filter(t ->"Cambridge".equals(t.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .forEach(System.out::println); //하나씩 출력!!

        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2)->t1.getValue() < t2.getValue() ? t1: t2);

//        Optional<Transaction> smallestTransaction =
//                transactions.stream()
//                                .min(comparing(Transaction::getValue));

//        System.out.println("highestValue"+highestValue);
//        System.out.println("smallestTransaction"+smallestTransaction);

        //5장
//        IntStream evenNumbers =
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a +b*b) % 1 ==0)
                                        .mapToObj(b ->
                                                new int[]{a,b,(int) Math.sqrt(a*a + b*b)}));

        pythagoreanTriples.limit(5)
                .forEach(t->
                        System.out.println(t[0] + ","+t[1]+","+t[2]));

//        Stream<double[]> pythagoreanTriples2 =
        Stream<double[]> pythagoreanTriples2 =
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100)
                        .mapToObj(b -> new double[]{a,b, Math.sqrt(a*a + b*b)})
                        .filter(t-> t[2]%1 ==0)); //세수의 세번째 요소는 반드시 정수!!

        System.out.println("pythagoreanTriples2"+pythagoreanTriples2);
        //5.8.1 값으로 스트림 만들기
        Stream<String> test = Stream.of("Modern", "Java","In","Action");
        test.map(String::toUpperCase).forEach(System.out::println);
        //스트림 비우기
        Stream<String> emptyStream = Stream.empty(); //empty() 메서드를 사용하여 빈 스트림을 생성

      //5.8.2 null이 될 수 있는 객체로 스트림 만들기
        //System.getProperty는 제공된 키에 대응하는 속성이 없으면 null을 반환한다.
        // 이런 메소드를 스트림에 활용하려면 다음처럼 null을 명시적으로 확인해야했다.
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream
                = homeValue == null ? Stream.empty() : Stream.of("Dfdfd");

        System.out.println(homeValueStream);

        //Stream.ofNullable을 이용하기
        Stream<String> homeValueStream2
                = Stream.ofNullable(System.getProperty("home"));
        System.out.println(homeValueStream2);

        //5.8.3 배열로 스트림 만들기
        int [] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum"+sum);

        //5.8.4 파일로 스트림 만들기
        //파일을 처리하는 I/O 연산에 사용하는 자바의 NIO API (비블록i/o) 도 스트림 API를 활용할 수 있도록 업데이트 되었다.
        long uniqueWords = 0;

        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){ //스트림은 자원을 자동으로 해제할 수 있는 AutoCloseable이므로 try- finally가 필요없다.
            uniqueWords = lines.flatMap(line ->Arrays.stream(line.split(" "))) //고유 단어 수 계산
                    .distinct() //중복제거
                    .count(); //단어 스트림 생성

            System.out.println("?"+uniqueWords);
        } catch (IOException e){
            //파일을 열다가 예외가 발생하면 처리한다.
        }

//글자 읽기

       try

        {
            Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
            lines.forEach(System.out::println);
        } catch (IOException e){
            //파일을 열다가 예외가 발생하면 처리한다.
           e.printStackTrace();
        }

       //5.8.5 함수로 무한 스트림 만들기
        //크기가 고정되지 않은 스트림! 요청할 때마다 주어진 함수를 이용해서 값을 만든다. 무제한으로 값을 계산할 수 있다. 하지만 보통 무한한 값을 출력하지
        //않도록 limit(n) 함수를 함께 연결해서 사용한다.

        //iterate 메서드
        Stream.iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::println);
       //요청할 때마다 값을 생산할 수 있어서 끝이 없어 무한 스트림을 만든다. 이런 스트림을 언바운드 스트림이라고 표현한다.

        //피보나치수열 집합
//        int[] t = new int[]{0,1};
//        초깃값 : new int[]{0,1}
        //new int[]{0,1,1, 1}
        Stream.iterate(new int[]{0,1},t -> new int[]{t[1] ,t[0]+t[1]})
        .limit(20)
                .forEach(t-> System.out.println("(" +t[0] + "," + t[1] + ")"));


        Stream.iterate(new int[]{0,1},t -> new int[]{t[1] ,t[0]+t[1]})
                .limit(10)
                .map(t->t[0] )
                .forEach(System.out::println);

        //0에서 시작해서 100보다 크면 숫자 생성 중단코드
        //두번째 인수가 언제까지 작업수행할 것인지의 기준으로 사용!!
        IntStream.iterate(0,n->n<100,n->n+4)
                .forEach(System.out::println);

        //filter 메소드를 사용해도 작업이 언제 중단되는지 몰라서 종료되지 않는다.

//        IntStream.iterate(0,n->n+4)
//                .filter(n->n<100)
//                .forEach(System.out::println);

        //스트림 쇼트서킷을 지원하는 takeWhile을 이용하는 것이 해법이다.
        IntStream.iterate(0,n->n+4)
                .takeWhile(n->n<100)
                .forEach(System.out::println);

        //무한스트림 만드는 generate . 얘는 생산된 각 값을 연속적으로 계산하지 않는다.
        //Supplier<T> 를 인수로 받아서 새로운 값을 생산한다.
        //언제 generate를 사용하는가. 우리하 사용한 발행자 supplier (메소드 참조 Math.random)는 상태가 없는 메서드, 즉 나중에 계산에 사용할 어떤
        //값도 저장해두지 않는다. 하지만 발행자에 꼭 상태가 없어야 하느넋은 아니다.

















    }
}
