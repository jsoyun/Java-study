package GodOfJava.src.main.java.java8.Chapter11;

import java.util.Optional;

public class Person {
    private Optional<Car> car;
    public Optional<Car> getCar(){
        return car;
    }


//    public static void main(String[] args) {
////        Optional<Car> optionalCar = Optional.empty(); //빈 Optional객체를 얻을 수 있다.
////        System.out.println("??"+optionalCar);
//        Person person = new Person();
//        Optional<Car> car =person.car;
//
//        Optional<Optional<Car>> not = Optional.of(car);
//
////        Optional<Insurance> optionalInsurance  = Optional.ofNullable(insurance);
////        Optional<String> name = optionalInsurance.map(Insurance::getName);
//
//        //이차원Optional
//        Optional<Person> optionalPerson = Optional.of(person);
//        Optional<String> name =
//                optionalPerson.map(Person::getCar)
//                        .map(Car::getInsurance)
//                        .map(Insurance::getName);
//
//
//    }

}
