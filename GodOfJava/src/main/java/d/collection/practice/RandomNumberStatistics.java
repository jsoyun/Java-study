package GodOfJava.src.main.java.d.collection.practice;

import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
public class RandomNumberStatistics {
    private final int DATA_BOUNDARY = 50;
    Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    public static void main(String[] args) {

        RandomNumberStatistics rns = new RandomNumberStatistics();
        rns.getRandomNumberStatistics();




    }

    public void getRandomNumberStatistics(){
        Random random = new Random();
        int max = 5000;
        while (max >0){
            int ran = random.nextInt(50);
            putCurrentNumber(ran);

            max -= 1;

        }

        printStatistics();


    }

    public void putCurrentNumber(int tempNumber) {

        hashtable.put(tempNumber, 1);
        if (hashtable.contains(hashtable.get(tempNumber))){
            hashtable.put(tempNumber, hashtable.get(tempNumber) +1);

        } else{
            hashtable.put(tempNumber, 1);
        }

    }

    public void printStatistics(){
        Set<Integer> Key =hashtable.keySet();
        for (Integer key : Key){
            System.out.print(key );
            System.out.println("="+hashtable.values());

            if (key%10-1 ==0) System.out.println();



        }

    }

}
