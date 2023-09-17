package GodOfJava.src.main.java.d.collection;

import java.util.ArrayList;
import java.util.Stack;

//ArrayList의 생성자는 3개다.
//        ArrayList() 객체를 저장할 공간이 10개인 ArrayList를 만든다.
//                ArrayList(Collection<? extends E> c) 매개변수로 넘어온 컬렉션 객체가 저장되어있는 ArrayList를 만든다.
//        ArrayList(int initialCapacity) 매개변수로 넘어온 initialCapacity 객수만큼의 저장공간을 갖는 ArrayList를 만든다.


//ArrayList는 Thread safe 하지 않다! Vector는 Thread safe하다!
//ArrayList를 여러 쓰레드에서 안전하게 만들려면 이런 객체를 생성해야한다.
//List list = Collections.synchronizedList(new ArrayList(...));

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
        //ArrayList
//        sample.checkArrayList1();
//        sample.checkArrayList2();
//        sample.checkArrayList3();
//        sample.checkArrayList4();
//        sample.checkArrayList5();

        //stack
        sample.checkStack();
    }

    public void checkArrayList1() {
        //객체를 리스트 형태로 넣을 수 있다.
        //컬렉션 관련 클래스의 객체들을 선언할 때는 제네릭을 사용하여 선언하는 것을 권장한다.
        //제네릭을 사용하여 컴파일 시점에 타입을 잘못지정한 부분을 걸러낼 수 있다.

        //ArrayList 객체 선언ㅇ시 매개변수 넣지 않으면 기본 초기 크기는 10이다.
        ArrayList<String> list1= new ArrayList<String>();
        list1.add("ArrayListSample");
    }

    public void checkArrayList2(){
        ArrayList<String> list =  new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(0,"FFF");

//        for(String tempData : list){
//            System.out.println(tempData);
//        }
//        ArrayList<String> list2 =  new ArrayList<>();
//        list2.add("0 ");
//        list2.addAll(list);
////        for(String tempDate : list2){
////            System.out.println("List2 "+ tempDate);
////        }
//        //Collection 인터페이스를 구현한 클래스 포함시킬 수 있는 생성자가 있어서 가능!
//        ArrayList<String> list3 = new ArrayList<>(list2);
//        list3.add("list3");
//        for(String tempDate : list3){
//            System.out.println("List3 "+ tempDate);
//        }

        ArrayList<String> list4 = list; //치환수행 //list4가 list의 값만 사용하겠다는 것이 아님! 원본객체의 주소값만 할당하는 것이다.
        list.add("OOPs");
        for (String tempData : list4){
            System.out.println("List4" +tempData);
        }

//        하나의 Collection 관련 객체를 복사할 일이 있을 때는 생성자를 사용하거나 addAll() 메소드를 사용을 권장!!



    }
    //ArrayList에서 데이터를 꺼내자
    public void checkArrayList3(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("A");

        //실제 들어있는 데이터의 갯수
//        int listSize = list.size();
//        for(int loop=0; loop <listSize; loop++){
//            System.out.println("list.get("+ loop+")="+list.get(loop));
//        }
//        Object[] strList = list.toArray();
//        Object[] strList2 = list.toArray(new String[0]);

        //ArrayList는 중복된 데이터를 넣을 수 있다.
        //데이터로 위치를 찾아내는 indexOf(객체) 매개변수로 넘어온 객체와 동일한 데이터의 위치를 리턴한다.
        // lastIndexOf(객체) 매개변수로 넘어온 객체와 동일한 마지막 데이터의 위치를 리턴한다.
        //없으면 -1리턴
        System.out.println("list.size"+list.size());
        System.out.println("indexOf"+list.indexOf("A"));
        System.out.println("indexOf"+list.lastIndexOf("A")); //맨 오른쪽에서부터 찾음



        //매개변수로 넘기는 배열은 의미없이 타입만을 지정하기 위해 사용할 수 있다.
        String[] tempArray = new String[0];
        String[] strList = list.toArray(tempArray);
        for (String temp: strList){
            System.out.println("temp:"+temp);
        }
    }

    //ArrayList 데이터 삭제
    public void checkArrayList4(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("A");
//        System.out.println("Removed" + list.remove(0));
        ArrayList<String> temp = new ArrayList<>();
        temp.add("A");
        list.removeAll(temp);

//        System.out.println( list.remove("A"));
        for(int loop=0; loop <list.size(); loop++){
                    System.out.println("list.get("+ loop+")="+list.get(loop));
        }
    }

    //ArrayList 데이터 값 변경
    public void checkArrayList5(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("A");

        list.set(0,"hi");
        for (String temp: list){
            System.out.println(temp);
        }
      //trimToSize() 저장할 수 있는 공간은 있으나 데이터 저장되어있지 않을 때 해당 공간을 없앤다.
        //ArrayList 객체를 원격으로 전송하거나 파일로 저장하는 일이 있을 때 이 메소드를 호출함으로써 데이터의 크기를 줄일 수 있다.


    }

    //Stack : LIFO 후입선출 기능을 구현하려고 할 때 필요한 클래스이다.
    //stack() 생성자- 아무 데이터도 없는 Stack객체를 만든다.
    public void checkStack(){
        Stack<Integer> intStack = new Stack<>();
        for (int loop = 0; loop <5; loop++){
            intStack.push(loop);
            System.out.println(intStack.peek()); //객체의 가장 위에 있는 데이터를 리턴한다.
        }

        while (! intStack.empty()){
            System.out.println(intStack.pop());
        }




    }






}
