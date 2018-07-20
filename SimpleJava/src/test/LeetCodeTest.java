import setest.PlusOne;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zsl on 2018/7/20.
 */
public class LeetCodeTest {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>(){{
            for (int element :
                    PlusOne.plusOne(new int[]{1,2,3}) ) {
                add(element);
            }
        }};
        System.out.println(list.toString());
    }
}
