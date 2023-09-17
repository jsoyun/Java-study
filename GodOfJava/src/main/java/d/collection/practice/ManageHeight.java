package GodOfJava.src.main.java.d.collection.practice;

import java.util.ArrayList;

public class ManageHeight {

    public ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<ArrayList<Integer>>();
    public double heightTotal =0;

    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
        manageHeight.printHeight();
        manageHeight.printAverage(2);

    }

    public void setData(){

        ArrayList<Integer> studentHeight = new ArrayList<>() ;

        Integer [] firstClass = {170, 180,173,175,177};
        for (Integer first : firstClass){
            studentHeight.add(first);
        }

        ArrayList<Integer> studentHeight2 = new ArrayList<>() ;
        Integer [] secondClass = {160, 165,167,186};
        for (Integer second : secondClass){
            studentHeight2.add(second);
        }
        ArrayList<Integer> studentHeight3 = new ArrayList<>() ;
        Integer [] thirdClass = {158, 177,187,176};
        for (Integer third : thirdClass){
            studentHeight3.add(third);
        }
        ArrayList<Integer> studentHeight4 = new ArrayList<>() ;
        Integer [] fourthClass = {173,182,181};
        for (Integer fourth : fourthClass){
            studentHeight4.add(fourth);
        }
        ArrayList<Integer> studentHeight5 = new ArrayList<>() ;
        Integer [] fifthClass = {170,180, 165, 177, 172};
        for (Integer fifth : fifthClass){
            studentHeight5.add(fifth);
        }



        gradeHeights.add(studentHeight);
        gradeHeights.add(studentHeight2);
        gradeHeights.add(studentHeight3);
        gradeHeights.add(studentHeight4);
        gradeHeights.add(studentHeight5);



    }
    //반 번호를 매개변수로 넘겨주면 학생들의 키번호를 순서대로 출력하는!
    public void printHeight(){



        for (int loop =0; loop <5; loop++){
            System.out.println(gradeHeights.get(loop));

        }


    }

    public void printAverage(int classNo){
        //반별 키의 평균
      System.out.println("classNo:" +(classNo +1)  );
      Double first = 0.0;
      for (Integer c : (gradeHeights.get(classNo))){
          first += c;



        }
       System.out.println("gradeHeights.size: "+ (first/(gradeHeights.get(classNo).size())));

    }
}
