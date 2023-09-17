package GodOfJava.src.main.java.d.collection;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class MapSample {
    public static void main(String[] args) {
        MapSample sample = new MapSample();
//        sample.checkHashMap();
//        sample.checkHashMapEntry();
//        sample.checkTreeMap();
//        sample.checkProperties();
        sample.saveAndLoadProperties();
    }

    public void checkHashMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("A","a");
        map.put("B","1");
        System.out.println(map.get("A"));
        System.out.println(map.get("a"));

        //keySet 키값 목록으로 가져옴
//        Set<String> keySet = map.keySet();
//        for (String tempKey : keySet){
//            System.out.println(tempKey);
//
//        }

        //값 얻기 values 값 목록으로 가져옴
        Collection<String> values = map.values();
        for (String tempValue: values){
            System.out.println(tempValue);
        }



    }


    //Entry에는 단 하나의 키와 값만이 저장된다.
    public void checkHashMapEntry(){
        HashMap<String, String> map = new HashMap<>();
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put("D","d");

        map.remove("A");

        Set<Entry<String,String>> entries = map.entrySet();
        for(Entry<String, String> tempEntry: entries){
            System.out.print(tempEntry.getKey());
            System.out.println(tempEntry.getValue());

        }
        //Map에 어떤 키나 값이 존재하는지 확인
//        System.out.println(map.containsKey("A"));
//        System.out.println(map.containsKey("Z"));
//
//        System.out.println(map.containsValue("a"));
//        System.out.println(map.containsValue("Z"));


    }
    public void checkTreeMap(){
        TreeMap<String,String> map = new TreeMap<>();
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put("나","나");
        map.put("D","d");
        map.put("가","가");
        map.put("2","2");
        map.put("1","1");
        map.put("1","f");

        Set<Entry<String ,String>> entries = map.entrySet();
        for (Entry<String ,String> tempEntry: entries){
            System.out.println(tempEntry.getKey() + "=" +tempEntry.getValue());
        }


    }
//Properties클래스는 Hashtable 클래스를 확장했다. 그래서 Map 인터페이스에서 제공하는 모든 메소드를 사용할 수 있다.
    public void checkProperties(){
        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for(Object tempObject: keySet){
            System.out.println(tempObject+"="+prop.get(tempObject));

        }
    }

    public  void saveAndLoadProperties(){
        try{
//            String fileName = "test.properties";
            String fileName = "test.xml";
            File propertiesFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(propertiesFile);
            Properties prop = new Properties();
            prop.setProperty("Writer","Sangmin Lee");
            prop.setProperty("Writer11","Sangmin Lee111");
//            prop.store(fos, "Basic Properties file");
            prop.storeToXML(fos, "Basic Properties file");
            fos.close();

            FileInputStream fis = new FileInputStream(propertiesFile);
            Properties propLoaded = new Properties();
//            propLoaded.load(fis);
            propLoaded.loadFromXML(fis);
            fis.close();
            System.out.println(propLoaded);





        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
