package example.zsltest;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
//        Son son = new Son();
//        System.out.println(son instanceof Father);

        String dateStr = "2020-02-12 12:18:33";
        String pa ="yyyyMMddHHmmss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pa);

        simpleDateFormat.setLenient(true);

        Date date = simpleDateFormat.parse(dateStr);

        String  dateStrafter = DateFormatUtils.format(date,pa);


        System.out.println(dateStrafter);
    }
}
