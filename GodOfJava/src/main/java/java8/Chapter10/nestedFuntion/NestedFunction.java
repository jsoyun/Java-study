package GodOfJava.src.main.java.java8.Chapter10.nestedFuntion;

import GodOfJava.src.main.java.java8.Chapter10.methodChain.Order;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Stock;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Trade;

import static GodOfJava.src.main.java.java8.Chapter10.nestedFuntion.NestedFunctionOrderBuilder.*;

public class NestedFunction {
    public static void main(String[] args) {
        Order order = order("BigBank" ,
                buy(80,
                    stock("IBM",on("NYSE")) , at(125.00)),
                sell(50,
                        stock("Google", on("NASDAQ")), at(375.00)));
    }


}
