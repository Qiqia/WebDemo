package example.zsltest;

import example.zsltest.DynamicProxy;
import example.zsltest.ITalk;
import example.zsltest.PeopleTalk;

/**
 * Created by zsl on 2018/12/27.
 */
public class TestDP {
    public static void main(String[] args) {
        ITalk iTalk = (ITalk) new DynamicProxy().bind(new PeopleTalk("张三","18"));
        iTalk.talk("业务说明");
    }
}
