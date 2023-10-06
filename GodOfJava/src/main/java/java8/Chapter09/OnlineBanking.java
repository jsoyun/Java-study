package GodOfJava.src.main.java.java8.Chapter09;

import java.util.function.Consumer;

class OnlineBanking {

    public static void main(String[] args) {
//        new OnlineBanking().processCustomer(1337 , (Customer c) -> System.out.println("고객한테 이걸주자") );
        new OnlineBanking().processCustomer(1337 , (Customer c) -> System.out.println("고객한테 이걸주자" + c.getName()) );
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);

    }
//    abstract void makeCustomerHappy(Customer customer);


    static private class Customer {
        private String name = "리리";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // 더미 Database 클래스
    static private class Database {

        static Customer getCustomerWithId(int id) {
            return new Customer();
        }

    }

}
