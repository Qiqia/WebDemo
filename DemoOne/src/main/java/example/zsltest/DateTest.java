package example.zsltest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zsl on 2019/9/3.
 */
public class DateTest {
    public static void main(String[] args)throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("y-MM-dd");
        Date date = dateFormat.parse("11111-11-11");
        System.out.println(date);


        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat YYYY = new SimpleDateFormat("YYYY-MM-dd");


        System.out.println(yyyy.parse("2015-12-25"));
        System.out.println(YYYY.parse("2015-12-25"));

        Date rightNow = new Date();
        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.text.DateFormat format2 = new SimpleDateFormat("y-M-d H:m:s");
        java.text.DateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
        java.text.DateFormat format4 = new SimpleDateFormat("h:mm a");
        java.text.DateFormat format5 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        java.text.DateFormat format6 = new SimpleDateFormat("EEE, MMM, dd, ''yyyy");
        java.text.DateFormat format7 = new SimpleDateFormat("yyyy.MM.dd kk:mm 'o''clock' a, zzzz");
        java.text.DateFormat format8 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");

        System.out.println("format1 = " + format1.format(rightNow));
        System.out.println("format2 = " + format2.format(rightNow));
        System.out.println("format3 = " + format3.format(rightNow));
        System.out.println("format4 = " + format4.format(rightNow));
        System.out.println("format5 = " + format5.format(rightNow));
        System.out.println("format6 = " + format6.format(rightNow));
        System.out.println("format7 = " + format7.format(rightNow));
        System.out.println("format8 = " + format8.format(rightNow));
    }
}
