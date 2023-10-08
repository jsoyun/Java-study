package GodOfJava.src.main.java.java8.Chapter10.LambdaOrder;

import GodOfJava.src.main.java.java8.Chapter10.methodChain.Stock;

public class StockBuilderLambda {
    private Stock stock = new Stock();
    public void symbol(String symbol){
        stock.setSymbol(symbol);
    }
    public void market(String market){
        stock.setMarket(market);
    }
}
