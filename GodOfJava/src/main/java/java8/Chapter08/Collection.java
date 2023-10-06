package GodOfJava.src.main.java.java8.Chapter08;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class Collection {
    public  static  void main(String[] args) {
        List<String> fri = Arrays.asList("ddf","df");
        fri.set(0,"///");

        Set<String> ff = new HashSet<>(Arrays.asList("1","2","3"));
        Set<String> f3 = Stream.of("1","2","3")
                .collect(Collectors.toSet());

//
//        referenceCodes.stream()
//                .map(code -> Character.toUpperCase(code.CharAt(0)) +
//                        code.substring(1))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        for(ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext()){
//            String code = iterator.next();
//            iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
//
//        }
//        referenceCodes.replaceAll( code ->
//                Character.toUpperCase(code.charAt(0)) + code.substring(1));
//
//        for(Map.Entry<String, Integer> entry : ageOfFriends.entrySet()){
//            String friend = entry.getKey();
//            Integer age = entry.getValue();
//            System.out.println(friend + "is" + age + " years old");
//        }
//
//        ageOfFriends.forEach((friend,age) -> System.out.println(friend + " is" + age + " years old"));
//
//        Map<String, String> favouriteMovies
//                = Map.ofEntries(
//                        entry("Raphael", "Strar Wars"),
//                entry("Eaphael", "trar Wars"),
//                entry("Caphael", "rar Wars")
//        );
//        favouriteMovies.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println); //사람이름을 알파벳순으로처리


//        Map<String, String> favouriteMovies
//                = Map.ofEntries(
//                entry("Raphael", "Strar Wars"),
//                entry("Eaphael", "trar Wars")
//        );
//        System.out.println(favouriteMovies.getOrDefault("Eaphael" ,"디폴트임다"));
//        System.out.println(favouriteMovies.getOrDefault("xxxx" ,"디폴트임다"));
//
//
//        Map<String, byte[]> dataToHash = new HashMap<>();
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }


//        lines.forEach(
//                line -> //line은 맵에서 찾을 키
//                        dataToHash.computeIfAbsent(line, this::calculateDigest) //키가 존재하지 않으면 동작을 실행
//        );
//
//        private byte[] calculateDigest(String key){ //헬퍼가 제공된 키의 해시를 계산할 것이다.
//            return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
//        }
        Map<String, List<String>> friendToMovies = new HashMap<>();
        String friend = "Raphael";
        List<String> movies = friendToMovies.get(friend);
        if(movies == null){
            movies = new ArrayList<>();
            friendToMovies.put(friend, movies); //없으면 새로운 값 추가
        }

        movies.add("스타워즈요?");
        movies.add("해리포터요?");
//        System.out.println(friendToMovies);

        friendToMovies.computeIfAbsent("soyun", name -> new ArrayList<>())
                .add("마틸다");

        System.out.println(friendToMovies);

        friendToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>())
                .add("킹받드랴슈");



        String key = "soyun";
        String value = "마틸다";


        String df= friendToMovies.get(key).toString();
        boolean test = value.equals(df);

        System.out.println(test);
        System.out.println("friendToMovies.get(key)"+friendToMovies.get(key));

        List<String> checkMovie = friendToMovies.get(key );
//        if (checkMovie != null){
//            for (String movie : checkMovie){
//                if (movie.equals(value)){
//
//                    friendToMovies.remove(key );
//                    System.out.println("삭제 완");
//
//                }
//            }
//        }
        System.out.println(friendToMovies);

        friendToMovies.remove(key,value);
        System.out.println(friendToMovies);

        if (friendToMovies.containsKey(key) && Objects.equals(df, value)){
//            friendToMovies.remove(key,value);//value와 값이 일치해야 삭제됨
            friendToMovies.remove(key);

            System.out.println("제거된"+friendToMovies);
//            return true;
        } else{

            System.out.println("안된"+friendToMovies);
//            return false;
        }

        Map<String, String> favouriteMovies = new HashMap<>(); //바꿀 수 있는 맵을 사용해야한다.

        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");
        favouriteMovies.replaceAll((newOne, movie) -> movie.toUpperCase());
        System.out.println(favouriteMovies);

        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond")
        );
        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "키가 중복돼")
        );
        //키가 중복되지 않으면 문제 없이 맵이 합쳐짐
        Map<String, String> everyone1 = new HashMap<>(family);
        everyone1.putAll(friends);
        System.out.println(everyone1);
        //유연하게 합치기
        Map<String, String> everyone2 = new HashMap<>(family);
        friends.forEach((k,v)->
                everyone2.merge(k,v,(movie1,movie2) -> movie1 + "&" + movie2));
        System.out.println(everyone2);

        //merge를 이용해 초기화
        Map<String, Long> movieToCount = new HashMap<>();
        String movieName = "JamesBound";
//        long count = movieToCount.get(movieName);
//        if (count == null){
//            movieToCount.put(movieName,1);
//        } else{
//            movieToCount.put(movieName,count+1);
//        }
        movieToCount.merge(movieName, 1L,(count, increment) -> count + 1L);

        //퀴즈
        //기존 코드
        Map<String, Integer> movieList = new HashMap<>();
        movieList.put("JamesCond",20);
        movieList.put("matrix",15);
        movieList.put("Harry potter",5);

        movieList.entrySet().removeIf(e-> e.getValue() <10 );

        Iterator<Map.Entry<String, Integer>> iterator =
                movieList.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() <10){
                iterator.remove();
            }
        }
        System.out.println(movieList);

        //맵의 최댓값 찾기
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallelismThreshold =1;
        Optional<Long> maxValue =
                Optional.ofNullable(map.reduceValues(parallelismThreshold,Long::max));
        System.out.println("maxValue"+maxValue);














    }
}
