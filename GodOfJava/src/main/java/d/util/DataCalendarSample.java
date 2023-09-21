package GodOfJava.src.main.java.d.util;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DataCalendarSample {
    public static void main(String[] args) {
        DataCalendarSample sample = new DataCalendarSample();
//        sample.checkDate();
//        sample.useCalendar();

        //자바의 Calendar 클래스에서 월은 0부터 11까지 이다. -> 2000년 12월 31일 이라는 뜻이다.
        Calendar calendar = new GregorianCalendar(2000,11, 31);
        sample.addAndRoll(calendar , 10);
    }


    public void checkDate() {
        Date date = new Date();
        System.out.println(date);

        long time = date.getTime();
        System.out.println(time);
        date.setTime(0); //한국은 GMT 시간상 + 9시간
        System.out.println(date);
    }

    public void useCalendar(){
        Calendar cal = Calendar.getInstance();
        Calendar greCal = new GregorianCalendar();

        System.out.println("cal"+cal);
        System.out.println("greCal"+greCal);

        int year = greCal.get(Calendar.YEAR);
        int month = greCal.get(Calendar.MONTH );
        int date = greCal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year +"/"+month +"/" + date);
        String monthKorea
                = greCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.KOREA);
        String monthUS
                = greCal.getDisplayName(Calendar.MONTH, Calendar.SHORT,Locale.US);
        System.out.println(monthKorea);
        System.out.println(monthUS);
    }

    public void addAndRoll(Calendar calendar, int amount){
        calendar.add(Calendar.DATE, amount); //10일 더함
        printCalendar(calendar);

        calendar.add(Calendar.DATE , -amount);
        printCalendar(calendar);

        calendar.roll(Calendar.DATE , amount);//상위값 바꾸지 않고 10일 더함 12월 10일이 된다.
        printCalendar(calendar);


    }
    public void printCalendar(Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        String month =
                calendar.getDisplayName(Calendar.MONTH , Calendar.LONG, Locale.KOREA);
        int date = calendar.get(Calendar.DATE);
        System.out.println(year + "/"+ month +"/"+ date);
    }
}
