package GodOfJava.src.main.java.d.lang;
//<숫자를 처리하는 클래스 Math>
//기본 자료형은 스택에 저장되어 관리한다.
//기본 자료형의 숫자를 객체로 처리할 때가 있다.
//기본 자료형으로 선언된 클래스들이 있다.
//Character와 Boolean을 제외한 숫자를 처리하는 클래스들 - Wrapper 클래스
//들은 자바 컴파일러에서 자동으로 형변환을 해주기에 기본자료형처럼 쓸 수 있다.

//random 메소드가 있는데 Math클래스에서 제공하는 메서드보다 java.util 페키지에서 제공하는 Random 클래스의 메소드를 쓰는 것이 좋다.

public class JavaLang {
    public static void main(String[] args) {
        JavaLang sample = new JavaLang();
//        sample.numberTypeCheck();
//        sample.numberMinMaxCheck();
//        sample.systemPropertiesCheck();
//        sample.mathCheck1();
//        sample.matchCheck2();
//        sample.matchCheck3();
        sample.matchCheck4();
    }



    public void numberTypeCheck(){
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);
        byte byte2 = Byte.parseByte(value2);
        System.out.println(byte1 +byte2);

        Integer refInt = Integer.valueOf(value1);
        Integer refInt2 = Integer.valueOf(value2);
        //참조자료형 더하기 연산 가능한건 String 이지만
        //Byte, Short, Integer, Long, Float, Double 타입들도 기본 자료형처럼 더하기 연산 가능 해쓸 수 있다.
        System.out.println(refInt + refInt2 + "7");


    }

    public void numberMinMaxCheck(){

        long startTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();


        System.out.println("Byte min =" + Byte.MIN_VALUE +"max=" + Byte.MAX_VALUE);
        System.out.println("Short min =" + Short.MIN_VALUE +"max=" + Short.MAX_VALUE);
        System.out.println("Integer min =" + Integer.MIN_VALUE +"max=" + Integer.MAX_VALUE);

        System.out.println("Integer.toBinaryString min=" + Integer.toBinaryString(Integer.MIN_VALUE )+"max toBinaryString=" +
                Integer.toBinaryString(Integer.MAX_VALUE)
                );
        System.out.println("Integer.toHexString min=" + Integer.toHexString(Integer.MIN_VALUE )+"max toHexString=" +
                Integer.toHexString(Integer.MAX_VALUE)
        );

        System.out.println("Long min =" + Long.MIN_VALUE +"max=" + Long.MAX_VALUE);
        System.out.println("Character min =" + (int)Character.MIN_VALUE +"max=" + (int)Character.MAX_VALUE);
        System.out.println("Float min =" + Float.MIN_VALUE +"max=" + Float.MAX_VALUE);
        System.out.println("Double min =" + Double.MIN_VALUE +"max=" + Double.MAX_VALUE);

        System.out.println("Mill second = "+ (System.currentTimeMillis() - startTime));
        System.out.println("Nano second="+(System.nanoTime() - startNanoTime));

    }

    public void systemPropertiesCheck(){
        System.out.println("java.version="+
                System.getProperty("java.version"));
        System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME"));
    }
    //절대값 및 부호
    public void mathCheck1(){
        double number1 = 45;
        double number2 = -45;
        System.out.println("Math.abs(45)=" + Math.abs(number1));
        System.out.println("Math.abs(45)=" + Math.abs(number2));

        System.out.println("Math.signum(45)=" + Math.signum(number1));
        System.out.println("Math.signum(45)=" + Math.signum(number2));

        System.out.println("Math.min(45)=" + Math.min(number1, number2));
        System.out.println("Math.max(45)=" + Math.max(number1,number2));
    }
    //올림 버림
    public void matchCheck2(){
        double [] numbers = new double[]{3.15, 3.62, -3.15, 3.62};
        for (double number: numbers){
            System.out.println(number);
            System.out.println("Math.round()="+ Math.round(number)); //반올림 round 매개변수 float,double 리턴타입 int,long
            System.out.println("Math.rint()="+ Math.rint(number)); //반올림 ring 매개변수 double 리턴타입 double
            System.out.println("Math.ceil()="+ Math.ceil(number)); //올림
            System.out.println("Math.floor()="+ Math.floor(number)); //버림
        }

    }

    //제곱과 제곱근
    public void matchCheck3(){
        System.out.println("Math.sqrt(1)="+ Math.sqrt(1));//매개변수의 제곱근
        System.out.println("Math.sqrt(2)="+ Math.sqrt(2));
        System.out.println("Math.cbrt(8)="+ Math.cbrt(8)); //매개변수의 세제곱근
        System.out.println("Math.cbrt(27)="+ Math.cbrt(27));
        System.out.println("Math.pow(2,2)="+ Math.pow(2,4)); //첫번째 매개변수의 두번째 매개변수만큼 제곱근을 구한다.2의 4승
        System.out.println("Math.scalb(2,4)="+ Math.scalb(2,4));//첫번째 매개변수 * 2의 4승
        System.out.println("Math.hypot(3,4)="+ Math.hypot(3,4)); // (첫번째 의 제곱 + 두번째의 제곱)의 제곱근 : 25-> 5
        System.out.println("Math.sqrt(Math.pow(3,4)+Math.pow(4,2))="+ Math.sqrt(Math.pow(3,4)+Math.pow(4,2))); //
    }

    //삼각함수 관련
    public void matchCheck4(){
        double number1 = 45;
        double number2 = 90;

        double radian45 = Math.toRadians(number1);
        double radian90 = Math.toRadians(number2);

        System.out.println("Radian value of 45 degree is"+ radian45);
        System.out.println("Radian value of 90 degree is"+ radian90);
    }
}
