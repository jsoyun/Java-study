package GodOfJava.src.main.java.java8.Chapter10.methodChain;

//메서드 체인 DSL을 제공하는 주문 빌더

public class MethodChainingOrderBuilder {
    public final Order order = new Order(); //빌더로 감싼 주문
    private MethodChainingOrderBuilder(String customer){
        order.setCustomer(customer);
    }
    public static MethodChainingOrderBuilder forCustomer (String customer){
        return new MethodChainingOrderBuilder(customer); //고객의 주문을 만드는 정적 팩토리 메서드
    }
    public TradeBuilder buy(int quantity){
        return new TradeBuilder(this, Trade.Type.BUY, quantity ); //주식을 사는 TradeBuilder 만들기

    }
    public TradeBuilder sell(int quantity){
        return new TradeBuilder(this, Trade.Type.SELL, quantity); //주식을 파는 TradeBuilder aksemfrl
    }

    public MethodChainingOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        System.out.println("???");
        return this;

    }

    public  double print(){
        return order.getValue();

    }

    public Order end(){
        return order;
    }
}
