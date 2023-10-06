package GodOfJava.src.main.java.java8.Chapter10.methodChain;

import static GodOfJava.src.main.java.java8.Chapter10.methodChain.MethodChainingOrderBuilder.forCustomer;

public class methodChain {


    public static void main(String[] args) {
        Order order = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("Google")
                .on("NASDAQ")
                .at(375.00)
//                .print();
                .end();
        System.out.println(order.getValue());
        System.out.println(order.getCustomer());
        order.setCustomer("고객");

        System.out.println(order.getCustomer());



    }
}
