package setest;

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
    }


    public static void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 2.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

    }
}
