package GodOfJava.src.main.java.java8;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;



import static java.util.stream.Collectors.toList;

public class StreamStringClass {
    public static void main(String[] args) {





        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        System.out.println("streamOfwords:"+streamOfwords);


        ArrayList<String> list = new ArrayList<String>();
        list.add("heelo");
        list.add("dfd");

        System.out.println("list"+ list);

//        List<Integer> wordLengths = words.stream()
//                .map(String::length)
//                .collect(toList());

//
        List<Integer> result =list.stream()
                .map(String::length)
                .collect(toList());

        System.out.println("result"+result);

        List<String> result2 =list.stream()
                .map(String::toString)
                .collect(toList());

        System.out.println("result2"+result2);

//flatMap 사용
        //각 단어를 개별 문자열로 이루워진 배열로 만든 다음에 각 배열을 별도의 스트림으로 만들어야한다.
        List<String> uniqueCharacters =
                list.stream()
                        .map(word -> word.split(" ")) //각단어를 개별 문자를 포함하는 배열로 전환
                        .flatMap(Arrays :: stream) //생성된 스트림을 하나의 스트림으로 평면화
                        .distinct()
                        .collect(toList());

        List<Integer> test =Arrays.asList(1,2,3,4,5);

        List<Integer> IntegerStream = test.stream()
//                .flatMap(n->n*n) //하나의 평면화된 스트림을 반환. 각 값을 스트림으로 만든 다음에 모든 스트림을 핳나의 스트림으로 연결
                .map(n->n*n) //
                .collect(toList());

        System.out.println("IntegerStream"+IntegerStream);




        List<Integer> test2 = Arrays.asList(1,2,3);
        List<Integer> test3 = Arrays.asList(3,4);


// test2.stream().flatMap(i-> test3.stream().map(j -> new int[]{i,j}))
////                .collect(toList());
//        .forEach(i ->{
//            System.out.println("////?/"+Arrays.toString(i));
//        });
//
//
//        String pairs = test2.stream()
//                .flatMap(i -> test3.stream().map(j -> new int[]{i, j}))
//                .map(pair -> Arrays.toString(pair))
//                .collect(Collectors.joining(", "));
//
//        System.out.println("pairs/////: " + pairs);


//        List<int[]> pairs = test2.stream()
        String pairs = test2.stream()
                .flatMap(i->
                        test3.stream()
                                .filter((j) ->((i+j) %3) ==0)
                                .map(j -> new int[]{i,j})
                )
                .map(pair -> Arrays.toString(pair))


//                .collect(toList());
                .collect(Collectors.joining());

        System.out.println("pairs"+pairs);




//        String resultOfInt = pairs.stream()
//                .flatMap(Arrays::stream)
//
////                .filter(Integer::toString);


//        List<Integer> newList = new ArrayList<>();
//
//        //for문으로 만들어보기
//        for (int i=0; i< test2.size();i++ ){
//            test2.get(0);
//            System.out.println("   test2.indexOf(0);"+   test2.get(i));
//            for (int j = 0; j< test3.size(); j++){
//                System.out.println("test3" + test3.get(j));
//
//                newList.add(test2.get(i) , test3.get(i));
//            }
//
//
//        }
//        System.out.println("newList"+newList);

        List<Integer> numbers = Arrays.asList(1,2,3);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> sum2 = numbers.stream().reduce((a,b)-> (a+b));
        System.out.println(sum2);

        Optional<Integer> minValue = numbers.stream().reduce(Integer::min);
        Optional<Integer> minValue2 = numbers.stream().reduce((x,y)->x<y ? x :y);
        System.out.println(minValue);
        System.out.println(minValue2);

        List<String> menu = Arrays.asList("rice","cake","pizza");

        int countOfMenu = menu.stream()
                .map(v -> 1)
                .reduce(0, Integer::sum);

        System.out.println(countOfMenu);









    }
}
