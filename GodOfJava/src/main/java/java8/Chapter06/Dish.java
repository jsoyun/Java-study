package GodOfJava.src.main.java.java8.Chapter06;



import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;



import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

    public static void main(String[] args) {
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories"+totalCalories);


        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
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
        Map<Dish.Type, Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType ,
                                groupingBy(dish ->{
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NOMAL;
                                    else return CaloricLevel.FAT;
                                }))
                );















    }



}

