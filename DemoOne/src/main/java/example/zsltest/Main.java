package example.zsltest;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        List<GoodBean> a = new ArrayList<GoodBean>() {{
            add(null);
        }};
        for (GoodBean x : a) {
            System.out.println(x.getId());
        }
//        Son son = new Son();
//        System.out.println(son instanceof Father);

//        String dateStr = "2020-02-12 12:18:33";
//        String pa ="yyyyMMddHHmmss";
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pa);
//
//        simpleDateFormat.setLenient(true);
//
//        Date date = simpleDateFormat.parse(dateStr);
//
//        String  dateStrafter = DateFormatUtils.format(date,pa);
//
//
//        System.out.println(dateStrafter);
    }
}
