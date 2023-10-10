package GodOfJava.src.main.java.java8.Chapter11;

import java.util.Optional;

public class mainOptionaTest {

    public String getCarInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");


    }
    public static void main(String[] args) {

//        Person person = new Person(); // 실제 객체 생성
//        mainOptionaTest mainOptionaTest = new mainOptionaTest();
//        System.out.println("mainOptionaTest.getCarInsuranceName(person): " + mainOptionaTest.getCarInsuranceName(person.getCar()));

        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);
        System.out.println("name: "+ name);

//        Optional<Person> person = Optional.ofNullable();



//        System.out.println("example.getCarInsuranceName(person): " + ));
//        example.getCarInsuranceName(Optional.of(person));

//        Optional<Person> person = Optional.of(new Person());
//        mainOptionaTest mainOptionaTest = new mainOptionaTest();
//       System.out.println(" mainOptionaTest.getCarInsuranceName(person)"+  mainOptionaTest.getCarInsuranceName(person));

//        public class Person{
//            private Car car;
//            public Optional<Car> getCarAsOptional(){
//                return Optional.ofNullable(car);
//            }
//        }

    }
}
