//package GodOfJava.src.main.java.java8;
//
//import java.util.List;
//
//import static java.awt.Color.GREEN;
//
//public class main {
//
//    class Apple{
//        public int Weight = 100;
//        public String Color ;
////        public void setHeight(int height){
////            this.height= height;
////        }
//        public int getWeight(){
//            return Weight;
//        }
//
//        public String getColor(){
//            return Color;
//        }
//
//    }
//
//    public interface AppleFormatter{
////        boolean test (Apple apple);
//        String accept(Apple e);
//    }
//
//    public class ApplyFancyFormatter implements AppleFormatter{
//
//        @Override
//        public String accept(Apple apple) {
//            String charactieristic =  apple.getWeight() > 150 ? "heavy" :
//                    "light";
//            return "A" + charactieristic + " " + apple.getColor()
//                    + " apple";
//
//
//        }
//    }
//
//    public class ApplySimpleFormatter implements AppleFormatter{
//
//
//        @Override
//        public String accept(Apple apple) {
//            return "An apple of " + apple.getWeight() + "g";
//        }
//    }
//
//
//    public static void prettyPrintApple(List<Apple> inventory,AppleFormatter formatter){
//        for (Apple apple : inventory){
//            String output = formatter.accept(apple);
//            System.out.println(output);
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        prettyPrintApple(inventory, new ApplyFancyFormatter() );
//    }
//}
