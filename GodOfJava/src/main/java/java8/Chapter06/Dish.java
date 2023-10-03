package GodOfJava.src.main.java.java8.Chapter06;



import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;



import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dish {

    public enum CaloricLevel {
        DIET,
        NOMAL,
        FAT
    }

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }

    public static final List<Dish> menu = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static final Map<String, List<String>> dishTags = new HashMap<>();
    static {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }
    //소수인지 판단하는 프레디케이트
//    public boolean isPrime(int candidate){
//        return IntStream.range(2, candidate) //2부터 candidate 미만 사이의 자연수를 생성한다.
//                .noneMatch(i -> candidate % i ==0); //스트림의 모든 정수로 candidate를 나눌 수 없으면 참을 반환한다.
//    }
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
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories"+totalCalories);


        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        System.out.println("mostCalorieDish"+mostCalorieDish);
        double avgCalories =
                menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("avgCalories"+avgCalories);
        IntSummaryStatistics menuStatics =
                menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuStatics"+menuStatics);

//        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu = menu.stream().map(Dish::getName)
                        .collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println("shortMenu"+shortMenu);
//        String s = menu.stream().collect(joining());



        String shortMenu2 = menu.stream()
                        .collect(reducing("", Dish::getName ,(s1,s2)-> s1+ s2));
        System.out.println("shortMenu2"+shortMenu2);

        String shortMenu3 = menu.stream().map(Dish::getName).collect(joining(","));

        System.out.println("shortMenu3"+shortMenu3);

        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories,(i,j)-> i+j));
        System.out.println("totalCalories2"+totalCalories2);

        Optional<Dish> mostCalorieDish2 =
                menu.stream().collect(reducing((d1,d2)-> d1.getCalories() > d2.getCalories() ? d1 :d2));
        System.out.println("mostCalorieDish"+mostCalorieDish2);



        int totalCaloriesIn208 =
                menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();


        System.out.println("totRalCaloriesIn208"+totalCaloriesIn208);



    //6.3 그룹화
        //메뉴로 그룹화
        //팩토리 메서드 Collectors.groupingBy를 이용
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        System.out.println("dishesByType"+dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(
                        groupingBy(dish ->{
                            if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NOMAL;
                            else return CaloricLevel.FAT;
                         })

                );
        //그룹화된 요소 조작
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream().filter(dish -> dish.getCalories() > 500)
                        .collect(groupingBy(Dish::getType));
        System.out.println("caloricDishesByType"+caloricDishesByType);
        //결과 : caloricDishesByType{OTHER=[french fries, pizza], MEAT=[pork, beef]}

        Map<Dish.Type, List<Dish>> caloricDishesByType2 =
                menu.stream().collect(groupingBy(Dish::getType,
                        filtering(dish-> dish.getCalories() > 500, toList())
                        ));
        System.out.println("caloricDishesByType2"+caloricDishesByType2);
        //결과 : caloricDishesByType2{FISH=[], OTHER=[french fries, pizza], MEAT=[pork, beef]}

        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        mapping(Dish::getName, toList())
                ));
        System.out.println("dishNamesByType"+dishNamesByType);
        //결과 : dishNamesByType{FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza], MEAT=[pork, beef, chicken]}

        //태그 목록을 가진 각 요리로 구성된 맵
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        //flatMapping 컬렉터를 이용하면 각 형식의 요리의 태그를 간편하게 추출할 수 있다.
        Map<Dish.Type, Set<String>> dishNamesByTypeUsingflatMapping =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish ->
                                    dishTags.get(dish.getName()).stream()
                                , toSet())));

        System.out.println("dishNamesByTypeUsingflatMapping"+dishNamesByTypeUsingflatMapping);

 //6.3.2 다수준 그룹화
        Map<Dish.Type,
                Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType ,
                                groupingBy(dish ->{
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NOMAL;
                                    else return CaloricLevel.FAT;
                                })
                        )
                );

        System.out.println("dishesByTypeCaloricLevel"+dishesByTypeCaloricLevel);
        //결과: dishesByTypeCaloricLevel{FISH={DIET=[prawns], NOMAL=[salmon]}, OTHER={DIET=[rice, season fruit], NOMAL=[french fries, pizza]}, MEAT={DIET=[chicken], NOMAL=[beef], FAT=[pork]}}


        //6.3.3 서브그룹으로 데이터 수집
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(
                        groupingBy(Dish::getType,counting())
                        // groupingBy(f) 는  groupingBy(f, toList()) 의 축약형이다.
                );
        System.out.println("typesCount"+typesCount);
        //결과  {FISH=2, OTHER=4, MEAT=3}

        //요리의 종류를 분류하는 컬렉터로 메뉴에서 가장 높은 칼로리를 가진 요리를 찾기
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType ,
                                maxBy(comparingInt(Dish::getCalories))));
        System.out.println("mostCaloricByType"+mostCaloricByType);
        //결과  {FISH=Optional[salmon], OTHER=Optional[pizza], MEAT=Optional[pork]}

        //컬렉터 결과를 다른 형식에 적용하기
        //팩토리 메서드 Collectors.collectingAndThen으로 컬렉터가 반환된 결과를 다른 형식으로 활용할 수 있다.
        //각 서브 그룹에서 가장 칼로리가 높은 요리 찾기
        Map<Dish.Type, Dish> mostCaloricByTypeUsingCollectingAndThen =
                menu.stream()
                        .collect(
                                groupingBy(
                                        Dish::getType , //분류함수
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)), //감싸인 컬렉터
                                        Optional::get //변환함수
                                )
                                )
                        );

        System.out.println("mostCaloricByTypeUsingCollectingAndThen:" +mostCaloricByTypeUsingCollectingAndThen);


//groupingBy와 함께 사용하는 다른 컬렉터 예제
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)
                        ));
        System.out.println("totalCaloriesByType:"+totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> CaloricLevelSet=
        menu.stream().collect(
                groupingBy(Dish::getType, mapping(

                        dish ->{
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NOMAL;
                    else return CaloricLevel.FAT;
                },
                        toSet()
                ))
        );
        System.out.println("CaloricLevelSet:"+CaloricLevelSet);

        //이전 예제에서는 Set의 형식이 정해져 있지 않았음
        //toCollection을 이용하면 원하는 방식으로 결과를 제어할 수 있다.
        Map<Dish.Type, Set<CaloricLevel>> CaloricLevelSetHashSet=
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(

                                dish ->{
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NOMAL;
                                    else return CaloricLevel.FAT;
                                },
                                toCollection(HashSet::new)
                        ))
                );
        System.out.println("CaloricLevelSetHashSet:"+CaloricLevelSetHashSet);

        //6.4 분할 - 분할함수 (partitioning function 라 불리는 프레디케이트를 분류함수로 사용하는 특수한 그룹화 기능이다. )
        //불리언을 반환해서 맵의 키 형식은 Boolean이다. 그룹화 맵은 참 거짓 값을 가져 최대 두 개의 그룹으로 분류된다.
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian)); //분할 함수
        System.out.println("partitionedMenu : "+partitionedMenu);
        //결과 {false=[pork, beef, chicken, prawns, salmon], true=[french fries, rice, season fruit, pizza]}

        //true인 키
        List<Dish> vegetarianDishes =
                partitionedMenu.get(true);
        System.out.println("vegetarianDishes : " +vegetarianDishes);
        //필터링하고 별도 리스트에 결과 수집
        List<Dish> vegetarianDishesToList =
                menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println("vegetarianDishesToList:"+vegetarianDishesToList);


//        6.4.1 분할의 장점 -> 스트림 리스트를 모두 유지한다는 것!!
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian, //분할함수
                                groupingBy(Dish::getType) //두번째 컬렉터
                                )
                );
        System.out.println("vegetarianDishesByType"+vegetarianDishesByType);
        //결과 false={FISH=[prawns, salmon], MEAT=[pork, beef, chicken]}, true={OTHER=[french fries, rice, season fruit, pizza]}}

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian ,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)
                                )
                );
        System.out.println("mostCaloricPartitionedByVegetarian"+mostCaloricPartitionedByVegetarian);
        //결과 {false=pork, true=pizza}

        //6.4.2 숫자를 소수와 비소수로 분할해보자! - 정수 n을 인수로 받아서 2에서 n까지의 자연수를 소수prime와 비소수 nonprime로
        //나누는 프로그램을 구현

        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));























    }



}

