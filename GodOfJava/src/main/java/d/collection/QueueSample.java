package GodOfJava.src.main.java.d.collection;

//LinkedList가 배열보다 메모리 공간 측면에 훨씬 유리하다
//LinkedList는 List 인터페이스뿐만 아니라 Queue와 Deque 인테페이스도 구현하고 있다.
//즉 LinkedList 자체가 List이면서 Queue, Deque(큐 인터페이스를 확장해서 맨앞에서 값넣거나 맨뒤에서 값빼는작업 수행용이)도 된다.


import java.util.LinkedList;

//LinkedList 생성자는 일반 배열타입의 클래스와 다르게 객체 생성할 때 처음부터 크기를 지정하지 않는다.
public class QueueSample {
    public static void main(String[] args) {
        QueueSample queueSample = new QueueSample();
        queueSample.checkLinkedList1();
    }

    public void checkLinkedList1() {
        LinkedList<String> link = new LinkedList<>();
        link.add("A");
        link.addFirst("B");
        System.out.println(link);

        link.offerFirst("C");
        System.out.println(link);

        link.addLast("D");
        link.offerLast("ff");
        System.out.println(link);
        link.push("G"); //맨앞에 저장
        System.out.println(link);
        link.add(0,"H");
        System.out.println(link);
        System.out.println("EX=" + link.set(0,"I"));
        System.out.println(link);




    }
}
