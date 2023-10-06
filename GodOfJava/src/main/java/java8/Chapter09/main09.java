package GodOfJava.src.main.java.java8.Chapter09;

import java.io.BufferedReader;
import java.io.FileReader;

public class main09 {
    interface Task{
        public void execute();
    }
    public static void doSomething(Runnable r){
        r.run();
    }
    public static void doSomething(Task a){
        a.execute();
    }

//    String oneLine = processFile();
//
//    public static String processFile(BufferedReaderProcessor p) throw IQException {
//        BufferedReader br = new BufferedReader( new FileReader("Dfd"));
//
//
//    }


}
