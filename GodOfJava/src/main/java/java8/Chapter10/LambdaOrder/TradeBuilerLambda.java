package GodOfJava.src.main.java.java8.Chapter10.LambdaOrder;

import GodOfJava.src.main.java.java8.Chapter10.methodChain.Stock;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.StockBuilder;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Trade;

import java.util.function.Consumer;

public class TradeBuilerLambda {
    Trade trade = new Trade();
    public void quantity (int quantity){
        trade.setQuantity(quantity);
    }
    public void price(double price){
        trade.setPrice(price);
    }
    public void stock(Consumer<StockBuilderLambda> consumer){
        StockBuilderLambda builder = new StockBuilderLambda();
        consumer.accept(builder);
//        trade.setStock(builder.);
    }



}
