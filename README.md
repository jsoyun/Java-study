# Java-study

5장 컬렉션
목록성 데이터를 처리하는 자료구조를 통칭한다.
자료구조: Data Structure 여러 데이터를 담을 때 사용

(배열에 데이터를 담는다면 배열의 크기를 미리 정해놔야해서 비효율적이고 메모리 낭비가 발생할 수 있다.)

데이터를 담는 자료구조
1. 순서가 있는 목록인 List 형 : 순서가 중요한 데이터 담기에 좋다. 중복 저장이 가능하다.
2. 순서가 중요하지 않은 목록인 Set형 : 순서 상관없이, 중복되는 것을 방지, 원하는 값이 포함되어있는지 확인이 주 용도
3. 먼저 들어온 것이 먼저 나가는 Queue형
4. 키key 값value으로 저장되는 Map형

자바에는 List, Set, Queue는 Collection이라는 인터페이스를 구현하고 있다. Map은 Collection과 관련없는 별도의 인터페이스를 구현하고 있다.


<img width="572" alt="image" src="https://github.com/jsoyun/Java-study/assets/89512178/e21cf901-7d00-4fa2-a445-587882b0f870">

List 인터페이스 : 구현 클래스 ArrayList , Stack 

Set 인터페이스 : 구현 클래스 HashSet , TreeSet, LinkedHashSet 
HashSet 순서필요없는 데이터를 해시테이블에 저장한다. set중에 성능이 가장 좋다. 
TreeSet 저장된 데이터의 값에 따라 정렬되는 set. 레드블랙 트리타입으로 값 저장, hashSet보다는 약간 성능 느리다. 
LinkedHashSet 연결된 목록 타입으로 구현된 해시테이블에 데이터를 저장한다. 저장된 순서에 따라 값 정렬된다, 대신 성능이 가장 느리다. 
 
Map 인터페이스 : 구현 클래스 HashMap, TreeMap, LinkedHashMap






