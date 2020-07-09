package example.service.impl;

import example.service.Axe;

/**
 * Created by zsl on 2018/7/5.
 */
public class StoneAxe implements Axe {
//    @OnMethod(remark = "石斧头的注解")
    public String chop(){
        return "石斧砍的好慢";
    }
}
