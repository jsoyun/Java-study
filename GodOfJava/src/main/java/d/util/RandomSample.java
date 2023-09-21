package GodOfJava.src.main.java.d.util;

import java.util.Random;

public class RandomSample {
    public static void main(String[] args) {
        RandomSample sample = new RandomSample();
        int randomCount = 10;
        sample.generateRandomNumbers( randomCount);
    }

    public void generateRandomNumbers(int randomCount){
        Random random = new Random();
        for (int loop =0; loop< randomCount; loop++){
            System.out.println(random.nextInt(100) + ",");
        }

    }
}
