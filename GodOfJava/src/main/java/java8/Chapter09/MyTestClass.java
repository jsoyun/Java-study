package GodOfJava.src.main.java.java8.Chapter09;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyTestClass {

    @Test
    public void testSomething() {
        // 테스트할 코드 및 검증 로직
//        int result = someMethodToTest();
//        assertEquals(5, result);
        Point p1 = new Point(5,5);
        Point p2 =p1.moveRightBy(10);
//        assertEquals(15,p2.getX());
//        assertEquals(5,p2.getY());
        int result = Point.compareByXAndThenY.compare(p1,p2);
        assertTrue(result <0);

    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception{
        List<Point> points =
                Arrays.asList(new Point(5,5), new Point(10,5));
        List<Point> expectedPoints =
                Arrays.asList(new Point(15,5), new Point(20,5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points,10);

        for (Point df : newPoints){
            System.out.println(df.getX());
            System.out.println(df.getY());
        }

//        assertEquals(expectedPoints, newPoints); //실패

        //통과
        for (int i = 0; i < expectedPoints.size(); i++) {
            assertEquals(expectedPoints.get(i).getX(), newPoints.get(i).getX());
            assertEquals(expectedPoints.get(i).getY(), newPoints.get(i).getY());
        }

    }

    // 테스트할 다른 메서드들...

//    private int someMethodToTest() {
//        // 테스트할 코드
//        return 5;
//    }
    @Test
    public void testFilter() throws Exception{
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> even = numbers.stream().filter( i -> i % 2 ==0).collect(Collectors.toList());
        List<Integer> smallerThanThree = numbers.stream().filter( i-> i<3).collect(Collectors.toList());
        assertEquals(Arrays.asList(2,4), even);
        assertEquals(Arrays.asList(1,2), smallerThanThree);

    }



}
