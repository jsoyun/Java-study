package GodOfJava.src.main.java.java8.Chapter06;

import GodOfJava.src.main.java.java8.Transaction;

import static GodOfJava.src.main.java.java8.Chapter06.Dish.menu;
import static java.util.stream.Collectors.*;



import java.util.*;
import java.util.stream.Collectors;




public class CollectorsClass {
    //return 타입 Map<Dish.Type, List<Dish>>


    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    public static void main(String[] args) {
        System.out.println("?"+menu.stream().map(Dish::getName).collect(joining()));
//        String shortMenu = menu.stream().collect(joining()); //안되는뎁
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());

        System.out.println("groupDishesByType"+groupDishesByType());

        ArrayList<String> menu = new ArrayList<>();
        menu.add("soup");
        menu.add("rice");




//        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes = menu.stream().count();
        System.out.println("howManyDishes" +howManyDishes);

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
//        Optional<Dish> mostCalorieDish =
//                menu.stream()
//                        .collect(maxBy(dishCaloriesComparator));
//        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

//        menu.stream().collect(summingInt(Dish::getCalories));
        //왜 여기서는 쓸 수 없을까?











    }
}
