package GodOfJava.src.main.java.java8;

import java.util.*;
import java.util.stream.Collectors;
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
        System.out.println("Transactionlist"+Transactionlist);

        List<String> citiesList = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println("citiesList"+citiesList);

        //distinct()대신에 스트림을 집합으로 변환하는 toSet() 을 사용할 수 있다.
        Set<String> citiesListUsingSet = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        System.out.println("citiesListUsingSet"+citiesListUsingSet);

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
        System.out.println("traderLis2t"+traderList2);


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
        System.out.println("traderNameList "+traderNameList);

        //밀라노에 거래자가 있는가? Boolean

      boolean checkTraderInMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
      System.out.println("checkTraderInMilan>>"+checkTraderInMilan);

      //6번
        transactions.stream()
                .filter(t ->"Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println); //하나씩 출력!!

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

        System.out.println("highestValue"+highestValue);
        System.out.println("smallestTransaction"+smallestTransaction);

    }
}
