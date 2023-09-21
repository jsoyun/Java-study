package GodOfJava.src.main.java.d.util;

import java.util.Arrays;

public class ArraysSample {
    public static void main(String[] args) {
        ArraysSample sample = new ArraysSample();
//        sample.checkSort();
        sample.checkFill();

    }

    public void checkSort() {
        int[] values = new int[] {1,5,3,2,4,7,6,10,8,9};
        Arrays.sort(values);
        String stringValues = Arrays.toString(values);
        System.out.println(stringValues);
    }
    public void checkFill(){
        int[] emptyArray = new int[10];
//        Arrays.fill(emptyArray, 1);
        Arrays.fill(emptyArray, 0,5,9);
        String stringValues = Arrays.toString(emptyArray);
        System.out.println(stringValues);
    }
}
