package GodOfJava.src.main.java.java8;

import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    enum Color{
        RED,
        GREEN

    }
    public static class Apple{

        public int weight = 0;
        public Color color ;

        public Apple(int weight, Color color){
            this.weight = weight;
            this.color = color;
        }
        public int getWeight(){
            return weight;
        }
        public void setWeight(int weight){
            this.weight = weight;
        }
        public Color getColor(){
            return color;
        }

        public void setColor(Color color){
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color=%s , weight = %d}}", color,weight);
        }
    }

    interface ApplePredicate{
        boolean test(Apple a);
    }



    static class AppleWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple a) {
            return a.getColor() == Color.RED;
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150 && a.getColor() == Color.RED;
        }
    }

    public static   List<Apple> filter (List<Apple> inventory , ApplePredicate p){
        List<Apple> result = new ArrayList<>();
    for(Apple appleInInventory : inventory){
        if (p.test(appleInInventory)){
            result.add(appleInInventory);


        }
    }
        return result;

    }
    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

//        List<Apple> list = new ArrayList<>();
//        list.add(        new Apple(80, Color.GREEN));
//        list.add(      new Apple(155, Color.GREEN));
//        list.add(               new Apple(120, Color.RED));

//        AppleColorPredicate appleColorPredicate = new AppleColorPredicate();
//        AppleRedAndHeavyPredicate appleRedAndHeavyPredicate = new AppleRedAndHeavyPredicate();
       List<Apple> ResultOfColorFilter =  filter(list, new AppleColorPredicate());
//        List<Apple> ResultOfColorFilter =  filter(list, appleRedAndHeavyPredicate);

       System.out.println("ResultOfColorFilter"+ResultOfColorFilter);

       List<Apple> redApples = filter(list, (Apple apple) -> Color.RED.equals(apple.getColor())
       );



    }
}
