package GodOfJava.src.main.java.java8.Chapter09;

public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
       this.strategy = v;
    }
    public boolean validate(String s){
        return strategy.execute(s);
    }

    public interface ValidationStrategy{
        boolean execute(String s);
    }
//    public static class IsAllLowerCase implements ValidationStrategy{
//
//        @Override
//        public boolean execute(String s) {
//            return s.matches("[a-z]+");
//        }
//    }
//    public static class IsNumeric implements ValidationStrategy{
//
//        @Override
//        public boolean execute(String s) {
//            return s.matches("\\d+");
//        }
//    }

    public static void main(String[] args) {

//        Validator numericValidator = new Validator(new IsNumeric());
//        boolean b1 = numericValidator.validate("aaaa");
//        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
//        boolean b2 = lowerCaseValidator.validate("bbbb");

        //람다로 바꿈

        Validator numericValidator = new Validator(s -> s.matches("\\d+"));
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(s->s.matches("[a-z]+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");

        System.out.println(b1);
        System.out.println(b2);

    }

}
