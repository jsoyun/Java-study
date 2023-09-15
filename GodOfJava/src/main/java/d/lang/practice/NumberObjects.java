package GodOfJava.src.main.java.d.lang.practice;

public class NumberObjects {
    public static void main(String[] args) {
        NumberObjects numberObjects = new NumberObjects();

//        System.out.println(numberObjects.parseLong("363030"));
        numberObjects.printOtherBase(1024);
    }
    //문자인지 숫자인지 검증 Character.isDigit ,Character.isLetter
    public long parseLong(String data){
       try{
           boolean ValueIsDigit = false;


           for (char text :data.toCharArray() ){
               if (Character.isDigit(text) ){
                   System.out.println("숫자가 맞아요~!");
                   ValueIsDigit = true;


               } else if (Character.isLetter(text)){
                   System.out.println("문자가 있습니다.");
                   ValueIsDigit = false;
                   break;
               }

           }

           if (ValueIsDigit){
               return Long.parseLong(data);
           }else{
               return -1;

           }


       } catch(NullPointerException e){
           e.printStackTrace();

       }

       return -1;





    }
    //value로 받은 값을 2진수, 8진수, 16진수로 변환하여 출력
    public void printOtherBase(long value){
        System.out.println(Long.toBinaryString(value));
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));



    }



}
