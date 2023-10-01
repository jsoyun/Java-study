package GodOfJava.src.main.java.java8;

import java.util.Comparator;

public class Transaction  {

//    @Override
//    public int compare(Transaction o1, Transaction o2) {
//        return 0;
//    }

//    @Override
//    public int compareTo(Transaction other) {
//        return Integer.compare(this.year, other.year);
//    }
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;

    }
    public Trader getTrader(){
        return  this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ","+
                "year" + this.year + "," +
                "value" + this.value + "}";
    }


}
