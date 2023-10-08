package GodOfJava.src.main.java.java8.Chapter10.LambdaOrder;

import GodOfJava.src.main.java.java8.Chapter10.methodChain.Order;
import GodOfJava.src.main.java.java8.Chapter10.methodChain.Trade;

import java.util.function.Consumer;

public class LambdaOrderBuilder {
    private static Order order = new Order();


    public static Order order(Consumer<LambdaOrderBuilder> consumer){
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder); //주문 빌더로 전달된 람다표현식 실행
        return builder.order; //OrderBuilder의 Consumer를 실행해 만들어진 주문을 반환
    }
    public static void forCustomer(String customer){
        order.setCustomer(customer); //주문을 요청한 고객 설정
    }
    public void buy(Consumer<TradeBuilerLambda> consumer){
        trade(consumer, Trade.Type.BUY);
    }
    public void sell(Consumer<TradeBuilerLambda> consumer){
        trade(consumer, Trade.Type.SELL);
    }

    private void trade(Consumer<TradeBuilerLambda> consumer, Trade.Type type) {
        TradeBuilerLambda builder = new TradeBuilerLambda();

        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);

    }


}
