package GodOfJava.src.main.java.d.collection.practice;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberMaker {
    public static void main(String[] args) {
        RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
        for(int loop =0; loop<9; loop++){
            System.out.println(randomNumberMaker.getSixNumber());
        }


    }

    public HashSet<Integer> getSixNumber(){

        HashSet<Integer> hasSet = new HashSet<>();
        while(hasSet.size() != 6){
            Random random = new Random();
            int tempNumber = random.nextInt(45);

            hasSet.add(tempNumber);

        }

        return hasSet;



    }
}
