//package GodOfJava.src.main.java.java8.Chapter10;
//
//import java.util.function.Function;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import static java.util.stream.Collectors.groupingBy;
//
//public class GroupingBuilder <T,D,K>{
//    private final Collector<? super T,? Map<K,D>> collector;
//    private GroupingBuilder(Collector<? super T, ?,Map<K,D>> collector){
//        this.collector = collector;
//    }
//    private Collector<? super T, ? , Map<K,D>> get(){
//        return collector;
//    }
//    public <J> GroupingBuilder<T, Map<K,D>,J> after(Function<? super T, ? extends J> classifier){
//        return new GroupingBuilder<T, Map<K, D>, J>(groupingBy(classifier,collector));
//    }
//
//    public static <T,D,K> GroupingBuilder<T, List<T>,K> groupOn(Function<? super T,? extends K> classifier) {
//        return new GroupingBuilder<T, List<T>, K>(groupingBy(classifier));
//    }
//
//
//
//}
