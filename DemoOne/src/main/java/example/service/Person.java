package example.service;

import example.utils.OnMethod;

/**
 * Created by zsl on 2018/7/5.
 */
public interface Person {
    @OnMethod(remark = "Person useAxe")
    public void useAxe();
}
