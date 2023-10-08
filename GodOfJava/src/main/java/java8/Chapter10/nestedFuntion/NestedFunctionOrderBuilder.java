package GodOfJava.src.main.java.java8.Chapter10.nestedFuntion;

import GodOfJava.src.main.java.java8.Chapter10.methodChain.Order;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Stock;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Trade;

import java.util.stream.Stream;

//중첩된 함수 DSL 을 제공하는 주문 빌더
public class NestedFunctionOrderBuilder {
    public  static Order order (String customer, Trade... trades){
        Order order = new Order(); //해당 고객의 주문 만들기
        order.setCustomer(customer);
        Stream.of(trades).forEach(order::addTrade);
        return order;
    }
    public static Trade buy(int quantity, Stock stock , double price){
        return buildTrade(quantity, stock, price, Trade.Type.BUY);
    }

    public static Trade sell(int quantity, Stock stock , double price){
        return buildTrade(quantity, stock, price, Trade.Type.SELL);
    }
    private static Trade buildTrade(int quantity, Stock stock, double price, Trade.Type buy){
        Trade trade = new Trade();
        trade.setQuantity(quantity);
        trade.setType(buy);
        trade.setStock(stock);
        trade.setPrice(price);
        return trade;
    }
    public static double at(double price){  //거래된 주식의 단가를 정의하는 더미 메서드
        return price;
    }
    public static Stock stock(String symbol, String market){
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setMarket(market);
        return stock;
    }
    public static String on(String market){
        return market;
    }


}
