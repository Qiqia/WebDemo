package example.zsltest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl on 2019/8/13.
 */
public class TestPlus {
    public static void main(String[] args) {
        System.out.println(1+"w");

        String xx = "20190908161911011483508516";
        int xxx = xx.hashCode();
        int xxxx = -xxx;
        System.out.println(xxx);
        System.out.println(xxxx);

        byte [] ss =null;
        if(ss == null){
            System.out.println("wanx");
        }

        List<Student> list = new ArrayList<Student>(){{
            add(new Student("zhangsan","5"));
            add(new Student("lisi","6"));
        }};
        list.forEach(a -> System.out.println(a.name));

        list.get(0).setName("wangwu");
        list.forEach(a -> System.out.println(a.name));
    }
}
