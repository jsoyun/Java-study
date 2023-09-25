package GodOfJava.src.main.java.e.thread.sync;

public class TestSample {
    public static void main(String[] args) {
        Test testThread1 = new Test("Thread1");
        Test testThread2 = new Test("Thread2");
        Test testThread3 = new Test("Thread3");

        testThread1.setPriority(1);
        testThread1.start();
        testThread2.setPriority(5);
        testThread2.start();
        testThread3.setPriority(10);
        testThread3.start();

    }
}
