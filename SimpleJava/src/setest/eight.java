package setest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zsl on 2018/9/10.
 */
public class eight {
    public static void main(String[] args) {


        filterTest();
        new Thread(()-> System.out.println("我是一个线程")).start();
        List<Integer> list = Arrays.asList(3,4,4,5,5,5,7);
        list.forEach(x-> System.out.println("我是"+x));

        List<Student> students = new ArrayList<Student>(){{
            add(new Student("a",1,"001"));
            add(new Student("b",2,"002"));
            add(new Student("c",3,"003"));
            add(new Student("d",4,"004"));
        }};

        students.sort((data1,data2)->data1.getAge()-data2.getAge());

        students.forEach(x-> System.out.println(x.getName()));

    }


    public static void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 2.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

    }
}
