package GodOfJava.src.main.java.d.collection;

import java.util.HashSet;
import java.util.Iterator;

//HashSet의 생성자들도 여러 종류가 있다.
public class SetSample {
    public static void main(String[] args) {
        SetSample setSample = new SetSample();
        String [] cars = new String[]{
                "Tico", "Sonata","Bmw","Bmw" ,"Benz", "Lexus","Zeep","Grandeure","Morning","Mini","Cooper","i30"
                ,"Grandeure","Morning"
        };
        System.out.println(setSample.getCarKinds(cars));

    }

    private int getCarKinds(String[] cars) {
        if (cars == null) return 0;
        //HashSet으로 저장하면 중복 저장안됨
        HashSet<String> carSet = new HashSet<>();
        for (String car: cars){
            carSet.add(car);
        }
        printCarSet(carSet);
        printCarSet2(carSet);
        return carSet.size();


    }
    //셋으로 저장한 내용 꺼내기 : 순서 뒤죽박죽~!
    public void printCarSet(HashSet<String> carSet){
        for (String temp: carSet){
            System.out.println(temp +" ");
        }
        System.out.println();
    }

    public void printCarSet2(HashSet<String> carSet){
        //반복자 사용해서 내용 꺼내기
        Iterator<String> iter = carSet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next() +"  ");
        }
        System.out.println();

    }

}
