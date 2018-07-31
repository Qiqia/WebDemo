package setest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl on 2018/7/31.
 */
public class ListTest {
    public static void main(String[] args) {
        String x="fa";
        List<String> list = new ArrayList<String>(){{
           add("dddfa"+x);
           add("zcfa");
        }};

        System.out.println(list.contains("dddfafa"));
        System.out.println(list.indexOf("zcfa"));
    }
}
