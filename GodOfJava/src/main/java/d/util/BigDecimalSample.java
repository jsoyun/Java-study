package GodOfJava.src.main.java.d.util;

import java.math.BigDecimal;

//돈계산할 때 쓰면 좋은 BigDecimal
public class BigDecimalSample {
    public static void main(String[] args) {
        BigDecimalSample sample = new BigDecimalSample();
//        sample.nomalDouble();
        sample.bigDecimalCalc();

    }
    public void nomalDouble(){
        double value = 1.0;
        for (int loop = 0; loop <10; loop++){
            value +=  0.1;
            System.out.println(value); //2.000000000000001 //float나 double은 근사치를 제공할 뿐 정확한 값을 제공하지 앖는다.
        }
    }
    public void bigDecimalCalc(){
//        BigDecimal value = new BigDecimal("1.0"); //정확한 계산을 위해서는 문자열을 매개변수로 받는 생성자 사용해야한다.
//        BigDecimal addValue = new BigDecimal("0.1");
        BigDecimal value = new BigDecimal(1.0);
        BigDecimal addValue = new BigDecimal(0.1);
        for (int loop =0; loop <10; loop++){
            value = value.add(addValue);
            System.out.println(value.toString());

        }


    }
}
